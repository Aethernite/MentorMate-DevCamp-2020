package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Interval application that sorts two numbers in ascending interval.
 */
public class IntervalApplication {
    private int numOne;
    private int numTwo;

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        printResult();
    }

    private void printResult() {
        int min = Math.min(numOne, numTwo);
        int max = Math.max(numOne, numTwo);
        System.out.println(String.format("[%d,%d]", min, max));
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("P=");
        numOne = scanner.nextInt();
        System.out.print("Q=");
        numTwo = scanner.nextInt();
        scanner.close();
    }
}
