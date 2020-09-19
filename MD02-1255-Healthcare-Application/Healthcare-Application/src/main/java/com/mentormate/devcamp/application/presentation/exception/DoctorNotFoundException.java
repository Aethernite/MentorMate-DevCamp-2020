package com.mentormate.devcamp.application.presentation.exception;

/**
 * The Doctor not found exception.
 */
public class DoctorNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Doctor not found exception.
     *
     * @param message the message
     */
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
