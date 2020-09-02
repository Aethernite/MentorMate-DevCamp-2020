package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Triangle printer application.
 *
 * 1 2 3 4 5 6 7
 *   2 3 4 5 6 7
 *     3 4 5 6 7
 *       4 5 6 7
 *         5 6 7
 *           6 7
 *             7
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
        for (int i = 1; i <= n; i++) {
            int whitespaces = 1;
            for (int k = 0; k < i - 1; k++) {
                System.out.print(" ");
                System.out.print(" ");
                whitespaces++;
            }
            for (int j = whitespaces; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
