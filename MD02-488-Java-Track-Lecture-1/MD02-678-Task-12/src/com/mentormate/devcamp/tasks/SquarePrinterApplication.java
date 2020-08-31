package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Square printer application.
 *
 *   * * * * * * * * * * * * *
 *   *       *       *       *
 *   *       *       *       *
 *   *       *       *       *
 *   * * * * * * * * * * * * *
 *
 */
public class SquarePrinterApplication {
    private int side;
    private int numberOfSquares;

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        printSquares();
    }

    private void printSquares() {
        for (int i = 0; i < side; i++) {
            int end = (side * numberOfSquares) - (side - numberOfSquares) - 1;
            for (int j = 0; j <= end; j++) {
                if (i==0 || i==side - 1 || j==0 || j==end || j % (side - 1)==0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Square side: ");
        side = scanner.nextInt();
        System.out.println("Number of squares: ");
        numberOfSquares = scanner.nextInt();
        scanner.close();
    }
}
