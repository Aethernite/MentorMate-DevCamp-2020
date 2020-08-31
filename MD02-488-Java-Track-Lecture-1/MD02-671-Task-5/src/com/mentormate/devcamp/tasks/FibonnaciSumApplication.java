package com.mentormate.devcamp.tasks;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * The Fibonnaci sum application.
 * 
 * The application sums the first N iterations and returns the result.
 */
public class FibonnaciSumApplication {
    private int iterations;

    /**
     * Start.
     */
    public void start() {
        getUserInput();
        System.out.println("Result: " + sumFibonacciNumbers(iterations));
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N=");
        iterations = scanner.nextInt();
        scanner.close();
    }

    private BigInteger sumFibonacciNumbers(int n) {
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger last = BigInteger.valueOf(0);
        BigInteger current = BigInteger.valueOf(1);
        int i;

        if (n < 1) {
            return BigInteger.valueOf(0);
        }

        for (i = 1; i < n; i++) {
            sum = sum.add(current);
            BigInteger next = last.add(current);
            last = current;
            current = next;
        }

        return sum;
    }
}
