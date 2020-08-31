package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Triangle printer application.
 * 
 * 
 *    1
 *    1 2
 *    1 2 3
 *    ...
 *    1 2 3 ... n
 */
public class TrianglePrinterApplication {
    private int iterations;

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        printTriangle(iterations);
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N=");
        int iterations = scanner.nextInt();
        scanner.close();
    }

    private void printTriangle(int n) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
