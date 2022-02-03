package com.mentormate.devcamp.application.presentation.exception;

/**
 * The No doctor role found exception.
 */
public class NoDoctorRoleFoundException extends RuntimeException {
    /**
     * Instantiates a new No doctor role found exception.
     *
     * @param message the message
     */
    public NoDoctorRoleFoundException(String message) {
        super(message);
    }
}
