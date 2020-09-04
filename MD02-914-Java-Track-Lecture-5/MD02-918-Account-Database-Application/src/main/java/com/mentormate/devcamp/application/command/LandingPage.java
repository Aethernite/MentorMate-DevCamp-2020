package com.mentormate.devcamp.application.command;

import java.util.Scanner;

import static com.mentormate.devcamp.application.styling.AnsiColorCodes.*;

public class LandingPage implements Command {
    private Command parent;
    private Scanner sc = new Scanner(System.in);

    public LandingPage(Command parent) {
        this.parent = parent;
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
                return new LoginPage(this);
            case '2':
                return new RegisterPage(this);
            case '3':
                return new Exit(this);
            default:
                System.out.println("Invalid choice!");
                return this;
        }
    }

    private void printMenu() {
        System.out.println(ANSI_YELLOW + "=========================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Options:" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "1)" + ANSI_RESET + "Login");
        System.out.println(ANSI_CYAN + "2)" + ANSI_RESET + "Register");
        System.out.println(ANSI_CYAN + "3)" + ANSI_RESET + "Exit");
        System.out.print(ANSI_YELLOW + "Enter choice:" + ANSI_RESET);
    }
}