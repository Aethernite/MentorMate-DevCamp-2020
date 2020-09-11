package com.mentormate.devcamp.application.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Belot game engine class.
 */
@Component(value = "Belot")
public class BelotGameEngine implements GameEngine {
    private static final Logger logger = LoggerFactory.getLogger(BelotGameEngine.class);

    @Override
    public void execute() {
        logger.info("Santase game engine is used");
    }

}
