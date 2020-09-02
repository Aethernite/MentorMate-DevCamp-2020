package com.mentormate.devcamp.util.exception;

/**
 * The type Iterator out of bounds exception.
 */
public class IteratorOutOfBoundsException extends Exception {
    public IteratorOutOfBoundsException() {
        super("The index is out of the array bounds!");
    }
}
