package com.mentormate.devcamp.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Sum calculator application.
 */
public class SumCalculatorApplication {
    private int iterations;
    private final Scanner scanner;

    /**
     * Instantiates a new Sum calculator application.
     */
    public SumCalculatorApplication() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        double sum = calculateSum();
        System.out.println(String.format("Result: %.2f", sum));
        scanner.close();
    }


    private void getUserInput() {
        System.out.print("N=");
        iterations = scanner.nextInt();
        if (iterations <= 0) {
            throw new InputMismatchException("The N must be a positive number!");
        }
    }

    private int calculateSum() {
        int sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += scanner.nextInt();
        }
        return sum;
    }
}
