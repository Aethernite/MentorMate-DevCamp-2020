package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Triangle printer application.
 */
public class TwoTrianglePrinterApplication {
    private int iterations;

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        printTriangles(iterations);
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N=");
        iterations = scanner.nextInt();
        scanner.close();
    }

    private void printTriangles(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; ++j) {
                System.out.print(j + " ");
            }
            System.out.print("  ");
            int whitespaces = 1;
            for (int k = 0; k < i; k++) {
                for (int ws = 0; ws < 4; ws++) {
                    System.out.print(" ");
                }
                whitespaces++;
            }
            for (int j = whitespaces; j <= n; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
