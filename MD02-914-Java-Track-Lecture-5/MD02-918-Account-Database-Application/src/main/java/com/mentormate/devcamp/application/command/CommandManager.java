package com.mentormate.devcamp.application.command;

/**
 * The Command manager.
 * <p>
 * Executes commands one by one until reaching Exit command.
 */
public class CommandManager {

    /**
     * The start method of the Command Manager.
     */
    public void start() {
        Command nextCommand = new LandingPage(null);
        while (nextCommand!=null) {
            nextCommand = nextCommand.execute();
        }
    }

}
