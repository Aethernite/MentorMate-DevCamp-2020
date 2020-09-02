package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Pyramid printer application.
 * <p>
 * *
 * * *
 * * * *
 */
public class PyramidPrinterApplication {
    private int iterations;
    private char symbol;

    /**
     * Start.
     */
    public void start() {
        getUserInput();
        printPyramid(iterations, symbol);
    }


    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N=");
        iterations = Integer.parseInt(scanner.nextLine());
        System.out.print("Symbol: ");
        symbol = scanner.nextLine().charAt(0);
        scanner.close();
    }

    private void printPyramid(int n, char symbol) {
        int space = n - 1;
        int j;
        /*run loop (parent loop) till number of rows*/
        for (int i = 0; i < n; i++) {
            /*loop for initially space, before star printing*/
            for (j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {
                System.out.print(symbol + " ");
            }

            System.out.println();
            space--;    /* decrement one space after one row*/
        }
    }
}
