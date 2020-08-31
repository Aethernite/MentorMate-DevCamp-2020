package com.mentormate.devcamp.tasks;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * The Fibonacci printer application.
 */
public class FibonacciPrinterApplication {
    private int iterations;

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        printFibonacciNumbers(iterations);
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N=");
        iterations = scanner.nextInt();
        scanner.close();
    }

    private void printFibonacciNumbers(int n) {
        BigInteger f1 = BigInteger.ZERO;
        BigInteger f2 = BigInteger.ONE;
        int i;

        if (n < 1) {
            return;
        }

        System.out.print(0 + " ");

        for (i = 1; i < n; i++) {
            System.out.print(f2 + " ");
            BigInteger next = f1.add(f2);
            f1 = f2;
            f2 = next;
        }
    }
}
