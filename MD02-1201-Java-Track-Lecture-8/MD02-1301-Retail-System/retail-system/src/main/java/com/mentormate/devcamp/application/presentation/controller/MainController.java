package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.BillService;
import com.mentormate.devcamp.application.business.service.UserService;
import com.mentormate.devcamp.application.persistence.entity.Bill;
import com.mentormate.devcamp.application.persistence.entity.User;
import com.mentormate.devcamp.application.persistence.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * The Main controller.
 */
@Controller
@RequiredArgsConstructor
public class MainController implements CommandLineRunner {
    private User logged;
    private final UserService userService;
    private final BillService billService;
    private static final Logger log = LogManager.getLogger(MainController.class);
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        run_loop:
        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: {
                    User user = getUserFromInput();
                    userService.createUser(user);
                    logged = user;
                }
                break;
                case 2: {
                    Bill bill = getBillFromInput();
                    billService.createBill(bill);
                }
                break;
                case 3: {
                    if (logged==null) {
                        log.info("You need to create a user first!");
                        break;
                    }
                    if (!billService.userHasBill(logged)) {
                        log.info("This user doesn't have a bill! Create a bill first!");
                        break;
                    }
                    Bill bill = billService.getBillByUserId(logged.getId());
                    log.info("Bill with discount for {} is ${}", logged.getUserRole(), bill.calculateWithDiscountByUser(logged));
                }
                break;
                case 4:
                    break run_loop;
            }
        }

    }

    private void printMenu() {
        log.info("Currently logged:{}", logged==null ? "no one":logged.getUsername());
        log.info("1) Create user ");
        log.info("2) Create bill");
        log.info("3) Calculate bill");
        log.info("4) Exit");
    }

    private Bill getBillFromInput() {
        log.info("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Bill(price, logged);
    }

    private User getUserFromInput() {
        log.info("Username: ");
        String username = scanner.nextLine();

        log.info("Email: ");
        String email = scanner.nextLine();

        log.info("First name: ");
        String firstName = scanner.nextLine();

        log.info("Last name: ");
        String lastName = scanner.nextLine();
        UserRole role;
        loop:
        while (true) {
            log.info("Select type of User 1)Customer, 2)Affiliate, 3)Employee: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    role = UserRole.CUSTOMER;
                    break loop;
                case 2:
                    role = UserRole.AFFILIATE;
                    break loop;
                case 3:
                    role = UserRole.EMPLOYEE;
                    break loop;
                default:
                    log.info("Invalid role!");
            }
        }

        return new User(username, email, firstName, lastName, role);
    }

}
