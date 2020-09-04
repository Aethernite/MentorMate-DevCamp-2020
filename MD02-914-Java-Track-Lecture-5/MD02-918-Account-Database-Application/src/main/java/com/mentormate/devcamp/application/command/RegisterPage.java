package com.mentormate.devcamp.application.command;

import com.mentormate.devcamp.application.database.Database;
import com.mentormate.devcamp.application.entity.Account;

import java.util.Scanner;

import static com.mentormate.devcamp.application.styling.AnsiColorCodes.*;

public class RegisterPage implements Command {
    private Command parent;
    private static Scanner sc = new Scanner(System.in);

    public RegisterPage(Command parent) {
        this.parent = parent;
    }

    @Override
    public Command execute() {
        System.out.println(ANSI_YELLOW + "=========================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Register form:" + ANSI_RESET);
        Account user = getAccount();
        return checkUser(user);
    }

    private Command checkUser(Account user) {
        if (Database.exists(user)) {
            System.out.println(ANSI_RED + "USER ALREADY EXISTS" + ANSI_RESET);
        } else {
            Database.insertAccount(user);
            System.out.println(ANSI_GREEN + "Registration successful!" + ANSI_RESET);
        }
        return new LandingPage(this);
    }

    private Account getAccount() {
        System.out.print("Enter email:");
        String email = sc.nextLine();
        System.out.print("Enter password:");
        String password = sc.nextLine();
        System.out.print("Enter first name:");
        String firstName = sc.nextLine();
        System.out.print("Enter last name:");
        String lastName = sc.nextLine();
        System.out.print("Enter date of birth:");
        String dateOfBirth = sc.nextLine();
        return new Account(firstName, lastName, email.toLowerCase(), dateOfBirth, password);
    }
}
