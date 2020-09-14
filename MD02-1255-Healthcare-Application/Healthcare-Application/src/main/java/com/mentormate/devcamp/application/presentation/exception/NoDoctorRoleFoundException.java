package com.mentormate.devcamp.application.presentation.exception;

public class NoDoctorRoleFoundException extends RuntimeException {
    public NoDoctorRoleFoundException(String message) {
        super(message);
    }
}
