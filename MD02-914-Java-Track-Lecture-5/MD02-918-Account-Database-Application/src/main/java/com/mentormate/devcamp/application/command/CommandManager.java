package com.mentormate.devcamp.application.command;

public class CommandManager {
    public void start() {
        Command nextCommand = new LandingPage(null);
        while (nextCommand!=null) {
            nextCommand = nextCommand.execute();
        }
    }
}