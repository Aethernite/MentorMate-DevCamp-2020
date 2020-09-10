package com.mentormate.devcamp.application.command;

import com.mentormate.devcamp.application.database.Database;
import com.mentormate.devcamp.application.entity.Account;

import java.util.Scanner;

import static com.mentormate.devcamp.application.styling.AnsiColorCodes.*;

/**
 * The Login page.
 */
public class LoginPage implements Command {
    private Command parent;
    private static Scanner sc = new Scanner(System.in);

    /**
     * Instantiates a new Login page.
     *
     * @param parent the parent command
     */
    public LoginPage(Command parent) {
        this.parent = parent;
    }

    @Override
    public Command execute() {
        System.out.println(ANSI_YELLOW + "=========================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Login form:" + ANSI_RESET);
        Account user = getAccount();
        if (Database.checkLogin(user)) {
            System.out.println(ANSI_GREEN + "LOGIN SUCCESSFUL!" + ANSI_RESET);
            return new MainMenuPage(this, Database.getAccount(user));
        }
        System.out.println(ANSI_RED + "Wrong password/User doesn't exist" + ANSI_RESET);
        return this.parent;
    }

    private Account getAccount() {
        System.out.print("Enter email:");
        String username = sc.nextLine();
        System.out.print("Enter password:");
        String password = sc.nextLine();
        return new Account(username, password);
    }
    
}
