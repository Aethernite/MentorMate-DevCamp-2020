package com.mentormate.devcamp.application.command;

import com.mentormate.devcamp.application.database.Database;
import com.mentormate.devcamp.application.entity.Account;

import java.util.Scanner;

import static com.mentormate.devcamp.application.styling.AnsiColorCodes.*;

/**
 * The Main menu page.
 */
public class MainMenuPage implements Command {
    private Command parent;
    private Account account;
    private Scanner sc = new Scanner(System.in);

    /**
     * Instantiates a new Main menu page.
     *
     * @param parent  the parent command
     * @param account the logged in account
     */
    public MainMenuPage(Command parent, Account account) {
        this.parent = parent;
        this.account = account;
    }

    @Override
    public Command execute() {
        printMenu();
        return interactWithUser();
    }

    private Command interactWithUser() {
        char choice = sc.nextLine().charAt(0);
        switch (choice) {
            case '1':
                Database.printAllAccounts();
                break;
            case '2':
                deleteAccountById();
                break;
            case '3':
                editAccountById();
                break;
            case '4':
                return new Exit(this);
            default:
                System.out.println("Invalid input!");
                return this;
        }
        return this;
    }

    private void printMenu() {
        System.out.println("USER:" + ANSI_CYAN + account.getFirstName() + " " + account.getLastName() + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "__________________________" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "1)" + ANSI_RESET + "List all accounts");
        System.out.println(ANSI_CYAN + "2)" + ANSI_RESET + "Delete account by id");
        System.out.println(ANSI_CYAN + "3)" + ANSI_RESET + "Edit account by id");
        System.out.println(ANSI_CYAN + "4)" + ANSI_RESET + "Exit");
        System.out.println("Choice:");
    }

    private void deleteAccountById() {
        System.out.println("Enter the id:");
        int id = Integer.parseInt(sc.nextLine());
        Database.delete(id);

    }

    private void editAccountById() {
        System.out.println("Enter the id:");
        int id = Integer.parseInt(sc.nextLine());
        if (!Database.existsById(id)) {
            System.out.println("User with id " + id + " doesn't exist in the database!");
            return;
        }
        Account accountToEdit = Database.getAccountById(id);
        System.out.println(accountToEdit);
        edit(accountToEdit);
    }

    private void edit(Account account) {
        System.out.println(account);
        while (true) {
            System.out.println("1) Email");
            System.out.println("2) First name");
            System.out.println("3) Last name");
            System.out.println("4) Password");
            System.out.println("5) Date of birth");
            System.out.println("6) Submit edit");
            System.out.println("Choose what to edit:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter new email:");
                    String email = sc.nextLine();
                    account.setEmail(email);
                    break;
                case 2:
                    System.out.println("Enter new first name:");
                    String firstName = sc.nextLine();
                    account.setFirstName(firstName);
                    break;
                case 3:
                    System.out.println("Enter new last name:");
                    String lastName = sc.nextLine();
                    account.setLastName(lastName);
                    break;
                case 4:
                    System.out.println("Enter new password:");
                    String password = sc.nextLine();
                    account.setPassword(password);
                    break;
                case 5:
                    System.out.println("Enter new date of birth:");
                    String dateOfBirth = sc.nextLine();
                    account.setPassword(dateOfBirth);
                    break;
                case 6:
                    Database.update(account);
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
