package com.mentormate.devcamp.application.presentation.exception;

public class AppointmentSlotBusyException extends RuntimeException {
    public AppointmentSlotBusyException(String message) {
        super(message);
    }
}
