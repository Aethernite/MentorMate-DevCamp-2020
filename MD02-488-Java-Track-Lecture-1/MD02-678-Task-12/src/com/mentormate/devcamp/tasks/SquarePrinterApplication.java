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
            int end = (side*numberOfSquares-numberOfSquares);
            for (int j = 0; j <= end; j++) {
                if (i==0 || i==side-1 || j==0 || j==end || j%(side-1)==0) {
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
        do {
            System.out.print("Square side: ");
            side = scanner.nextInt();
            if(side < 2){
                System.out.println("Side must be > 2!");
            }
        } while(side < 2);
        do {
            System.out.print("Number of squares: ");
            numberOfSquares = scanner.nextInt();
            if(numberOfSquares<=0){
                System.out.println("Number of squares must be > 0!");
            }
        }while(numberOfSquares <= 0);
        scanner.close();
    }
}
