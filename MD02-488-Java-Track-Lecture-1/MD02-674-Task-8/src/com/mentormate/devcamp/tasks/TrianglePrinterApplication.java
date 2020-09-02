package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Triangle printer application.
 *
 *
 *    1 2 3 4 5 6 7
 *    1 2 3 4 5 6
 *    1 2 3 4 5
 *    1 2 3 4
 *    1 2 3
 *    1 2
 *    1
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
        iterations = scanner.nextInt();
        scanner.close();
    }

    private void printTriangle(int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n + 1; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
