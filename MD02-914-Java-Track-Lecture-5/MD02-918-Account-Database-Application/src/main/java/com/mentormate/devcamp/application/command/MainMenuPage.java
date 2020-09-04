package com.mentormate.devcamp.application.command;

import com.mentormate.devcamp.application.database.Database;
import com.mentormate.devcamp.application.entity.Account;

import java.util.Scanner;

import static com.mentormate.devcamp.application.styling.AnsiColorCodes.*;

public class MainMenuPage implements Command {
    private Command parent;
    private Account account;
    private Scanner sc = new Scanner(System.in);

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
                //TODO
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
}
