package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.exception.NonMultiplicativeMatrixException;
import com.mentormate.devcamp.application.thread.WorkerThread;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * The Matrix multiplication application.
 */
public class MatrixMultiplicationApplication {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private WorkerThread[][] threads;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws NonMultiplicativeMatrixException if the two matrices can't be multiplied
     * @throws InterruptedException             if a thread is interrupted
     */
    public static void main(String[] args) throws NonMultiplicativeMatrixException, InterruptedException {
        var application = new MatrixMultiplicationApplication();
        application.start();
    }

    private void getUserInput() throws NonMultiplicativeMatrixException {
        System.out.println("Remember: The columns of matrix 1 must be equal to the rows of matrix 2!!!");
        System.out.println("Enter dimensions(R C) for first matrix:");
        matrix1 = getMatrixByUserInput();
        System.out.println("Enter dimensions(R C) for second matrix:");
        matrix2 = getMatrixByUserInput();
        if (matrix1[0].length!=matrix2.length) {
            throw new NonMultiplicativeMatrixException();
        }
    }

    private int[][] getMatrixByUserInput() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.out.println(String.format("Enter row %d like this (1 2 3):", i + 1));
            int[] row = Stream.of(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = row;
        }

        return matrix;
    }

    /**
     * The start method of the application.
     *
     * @throws NonMultiplicativeMatrixException if the two matrices can't be multiplied
     * @throws InterruptedException             if a thread is interrupted
     */
    public void start() throws NonMultiplicativeMatrixException, InterruptedException {
        getUserInput();
        result = new int[matrix1.length][matrix2[0].length];
        initializeThreads();
        waitThreadsToFinish();
        printResult(result);
    }

    public int[][] start(int[][] matrix1, int[][] matrix2) throws NonMultiplicativeMatrixException, InterruptedException {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        if (matrix1[0].length!=matrix2.length) {
            throw new NonMultiplicativeMatrixException();
        }
        result = new int[matrix1.length][matrix2[0].length];
        initializeThreads();
        waitThreadsToFinish();
        return result;
    }

    private void initializeThreads() {
        int r = matrix1.length;
        int c = matrix2[0].length;
        threads = new WorkerThread[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                threads[i][j] = new WorkerThread(i, j, matrix1, matrix2, result);
                threads[i][j].start();
            }
        }
    }

    private void waitThreadsToFinish() throws InterruptedException {
        for (Thread[] threadRow : threads) {
            for (Thread thread : threadRow) {
                thread.join();
            }
        }
    }

    private void printResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}