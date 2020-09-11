package com.mentormate.devcamp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Healthcare application.
 * <p>
 * Application created for a small healthcare company that needs an application to solve common problems.
 *
 * @author Borislav Arangelov
 * @since 11/09/2020
 */
@SpringBootApplication
public class HealthcareApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(HealthcareApplication.class, args);
    }

}
