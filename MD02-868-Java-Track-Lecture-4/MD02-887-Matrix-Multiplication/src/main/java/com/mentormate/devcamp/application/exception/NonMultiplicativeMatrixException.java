package com.mentormate.devcamp.application.exception;

public class NonMultiplicativeMatrixException extends Exception {
    public NonMultiplicativeMatrixException() {
        super("The two matrices are can't be multiplied by each other.");
    }
}
