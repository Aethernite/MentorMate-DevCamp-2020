package com.mentormate.devcamp.application.presentation.exception;

/**
 * The type Appointment slot busy exception.
 */
public class AppointmentSlotBusyException extends RuntimeException {
    /**
     * Instantiates a new Appointment slot busy exception.
     *
     * @param message the message
     */
    public AppointmentSlotBusyException(String message) {
        super(message);
    }
}
