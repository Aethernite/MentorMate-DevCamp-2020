package com.mentormate.devcamp.application.runner;

import com.mentormate.devcamp.application.engine.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameEngineRunner implements CommandLineRunner {
    @Autowired
    @Qualifier("Belot")
    private GameEngine belotEngine;
    @Autowired
    @Qualifier("Santase")
    private GameEngine santaseEngine;

    @Override
    public void run(String... args) throws Exception {
        belotEngine.execute();
        santaseEngine.execute();
    }
}
