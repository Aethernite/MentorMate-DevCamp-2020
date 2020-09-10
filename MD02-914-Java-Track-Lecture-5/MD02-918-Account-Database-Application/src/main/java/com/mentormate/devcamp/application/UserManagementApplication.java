package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.command.CommandManager;
import com.mentormate.devcamp.application.database.Database;

/**
 * The User management application.
 */
public class UserManagementApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        UserManagementApplication application = new UserManagementApplication();
        application.start();

    }

    /**
     * The start method of the application.
     */
    public void start() {
        Database.initialize();
        CommandManager commandManager = new CommandManager();
        commandManager.start();
    }

}
