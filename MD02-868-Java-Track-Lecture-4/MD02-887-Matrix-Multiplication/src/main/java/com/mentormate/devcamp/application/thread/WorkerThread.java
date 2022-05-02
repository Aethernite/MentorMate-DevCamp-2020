package com.mentormate.devcamp.application.thread;

/**
 * The Worker thread.
 * <p>
 * One thread is working only on one cell
 */
public class WorkerThread extends Thread {
    
    private final int row;
    private final int col;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] result;

    /**
     * Instantiates a new Worker thread.
     *
     * @param row          the row
     * @param col          the col
     * @param matrix1      the matrix 1
     * @param matrix2      the matrix 2
     * @param matrixResult the matrix result
     */
    public WorkerThread(int row, int col, int[][] matrix1,
                        int[][] matrix2, int[][] matrixResult) {
        this.row = row;
        this.col = col;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = matrixResult;
    }

    @Override
    public void run() {
        int temp = 0;
        for (int i = 0; i < matrix1[0].length; i++) {
            temp = temp + matrix1[row][i] * matrix2[i][col];
        }
        result[row][col] = temp;
    }
}
