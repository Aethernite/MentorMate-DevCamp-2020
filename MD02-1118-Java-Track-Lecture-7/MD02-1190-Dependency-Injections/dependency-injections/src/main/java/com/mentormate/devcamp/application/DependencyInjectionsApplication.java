package com.mentormate.devcamp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Dependency injections application.
 * <p>
 * Simple application to test the dependency injections in Spring Boot
 *
 * @author Borislav Arangelov
 * @since 11/09/2020
 */
@SpringBootApplication
public class DependencyInjectionsApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionsApplication.class, args);
    }

}
