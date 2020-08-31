package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * Arithmetic application that applies certain arithmetic operations on operands.
 */
public class ArithmeticApplication {
    private int code;
    private int numOne;
    private int numTwo;


    /**
     * The start method for the application.
     */
    public void start() {
        getUserInput();
        Operation operation = Operation.operationFromCode(code);
        System.out.print(String.format("Result: %d", getResult(operation)));
    }

    private int getResult(Operation operation) {
        switch (operation) {
            case ADDITION:
                return numOne + numTwo;
            case SUBTRACTION:
                return numOne - numTwo;
            default:
                throw new IllegalStateException("Unexpected operation: " + operation);
        }
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Code: ");
        this.code = scanner.nextInt();
        System.out.print("First number: ");
        this.numOne = scanner.nextInt();
        System.out.print("Second number: ");
        this.numTwo = scanner.nextInt();
        scanner.close();
    }
}
