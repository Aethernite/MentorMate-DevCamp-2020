package com.mentormate.devcamp.application.presentation.exception;

/**
 * The Drug not owned exception.
 */
public class DrugNotOwnedException extends RuntimeException {
    /**
     * Instantiates a new Drug not owned exception.
     *
     * @param message the message
     */
    public DrugNotOwnedException(String message) {
        super(message);
    }
}
