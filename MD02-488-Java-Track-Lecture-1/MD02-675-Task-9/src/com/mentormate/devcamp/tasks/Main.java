package com.mentormate.devcamp.tasks;

import java.util.Scanner;
/**
 * The main.
 * <p>
 * This is the entry point of the program.
 *
 * @author Borislav Arangelov
 * @version 1.0.0
 * @since 2020-07-20
 */
public class Main {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N=");
        int iterations = scanner.nextInt();
        printTriangle(iterations);
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

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
