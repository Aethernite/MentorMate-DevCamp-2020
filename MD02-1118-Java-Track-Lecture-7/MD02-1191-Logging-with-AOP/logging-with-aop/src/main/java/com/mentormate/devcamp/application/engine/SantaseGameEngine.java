package com.mentormate.devcamp.application.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Santase game engine class.
 */
@Component(value = "Santase")
public class SantaseGameEngine implements GameEngine {
    private static final Logger logger = LoggerFactory.getLogger(SantaseGameEngine.class);

    @Override
    public void execute() {
        logger.info("Santase game engine is used");
    }

}
