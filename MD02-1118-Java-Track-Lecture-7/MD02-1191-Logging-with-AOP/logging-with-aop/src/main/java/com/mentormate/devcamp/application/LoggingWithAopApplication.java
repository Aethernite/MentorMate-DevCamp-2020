package com.mentormate.devcamp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Logging application.
 * <p>
 * Simple application used for testing the logging with AOP
 *
 * @author Borislav Arangelov
 * @since 11/09/2020
 */
@SpringBootApplication
public class LoggingWithAopApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(LoggingWithAopApplication.class, args);
    }

}
