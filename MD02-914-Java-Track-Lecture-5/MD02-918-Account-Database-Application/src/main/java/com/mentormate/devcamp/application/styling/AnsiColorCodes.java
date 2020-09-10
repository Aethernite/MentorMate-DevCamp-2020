package com.mentormate.devcamp.application.styling;

/**
 * The Ansi color codes used for console text/background coloring.
 */
public class AnsiColorCodes {
    /**
     * The constant ANSI_RESET.
     * <p>
     * Resets the color of the console to normal
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * The constant ANSI_RED.
     */
    public static final String ANSI_RED = "\u001B[31m";
    /**
     * The constant ANSI_GREEN.
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    /**
     * The constant ANSI_YELLOW.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    /**
     * The constant ANSI_CYAN.
     */
    public static final String ANSI_CYAN = "\u001B[36m";

    private AnsiColorCodes() {
    }
}
