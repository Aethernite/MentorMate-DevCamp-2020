package com.mentormate.devcamp.application.command;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute the body of a command.
     *
     * @return next command
     */
    Command execute();
}
