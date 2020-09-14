package com.mentormate.devcamp.application.presentation.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
