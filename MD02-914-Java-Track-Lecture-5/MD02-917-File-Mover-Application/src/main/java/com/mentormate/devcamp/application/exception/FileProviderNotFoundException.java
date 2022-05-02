package com.mentormate.devcamp.application.exception;

/**
 * The File provider not found exception.
 */
public class FileProviderNotFoundException extends Exception {
    /**
     * Instantiates a new File provider not found exception.
     */
    public FileProviderNotFoundException() {
        super("File provider was not found");
    }
}
