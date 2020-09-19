package com.mentormate.devcamp.application.presentation.handler;

import com.mentormate.devcamp.application.presentation.exception.AppointmentSlotBusyException;
import com.mentormate.devcamp.application.presentation.exception.InvalidRoleException;
import com.mentormate.devcamp.application.presentation.exception.NoDoctorRoleFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * The Http exception handlers class.
 * <p>
 * This class contains all of the needed {@link ExceptionHandler}
 */
@Slf4j
@ControllerAdvice
public class HttpExceptionHandlers {

    /**
     * Entity not found exception response entity.
     *
     * @param e the exception
     * @return the response entity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Username not found exception response entity.
     *
     * @param e the exception
     * @return the response entity
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> usernameNotFoundException(UsernameNotFoundException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Invalid role exception response entity.
     *
     * @param e the exception
     * @return the response entity
     */
    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<String> usernameNotFoundException(InvalidRoleException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * No Doctor Role Found exception response entity.
     *
     * @param e the exception
     * @return the response entity
     */
    @ExceptionHandler(NoDoctorRoleFoundException.class)
    public ResponseEntity<String> usernameNotFoundException(NoDoctorRoleFoundException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Appointment Slot Busy exception response entity.
     *
     * @param e the exception
     * @return the response entity
     */
    @ExceptionHandler(AppointmentSlotBusyException.class)
    public ResponseEntity<String> usernameNotFoundException(AppointmentSlotBusyException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
