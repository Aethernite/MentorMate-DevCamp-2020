package com.mentormate.devcamp.application.exception;

/**
 * The File extension not found exception
 */
public class FileExtensionNotFoundException extends Exception {
    /**
     * Instantiates a new File extension not found exception.
     */
    public FileExtensionNotFoundException() {
        super("File extension was not found");
    }
}
