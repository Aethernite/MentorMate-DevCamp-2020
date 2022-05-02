package com.mentormate.devcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Greeting Application.
 * <p>
 * Simple application using a REST controller to test maven build tool
 */
@SpringBootApplication
public class Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
