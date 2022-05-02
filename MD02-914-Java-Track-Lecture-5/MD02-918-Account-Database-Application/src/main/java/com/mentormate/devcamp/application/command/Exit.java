package com.mentormate.devcamp.application.command;

/**
 * The Exit command.
 * <p>
 * Simply returns null when executed.
 */
public class Exit implements Command {
    private Command parent;

    /**
     * Instantiates a new Exit.
     *
     * @param parent the parent command
     */
    public Exit(Command parent) {
        this.parent = parent;
    }

    @Override
    public Command execute() {
        return null;
    }
}
