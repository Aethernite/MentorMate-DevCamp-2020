package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.command.CommandManager;
import com.mentormate.devcamp.application.database.Database;
import com.mentormate.devcamp.application.entity.Account;

public class UserManagementApplication {
    private static Account account;

    public UserManagementApplication() {
        account = null;
    }

    public static void setAccount(Account acc) {
        account = acc;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        UserManagementApplication application = new UserManagementApplication();
        application.start();

    }

    public void start() throws ClassNotFoundException {
        Database.initialize();
        CommandManager commandManager = new CommandManager();
        commandManager.start();

    }
}
