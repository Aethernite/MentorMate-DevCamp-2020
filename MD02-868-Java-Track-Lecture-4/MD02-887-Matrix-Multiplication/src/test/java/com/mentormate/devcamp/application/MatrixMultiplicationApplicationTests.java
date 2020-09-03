package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.exception.NonMultiplicativeMatrixException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixMultiplicationApplicationTests {

    @Test
    public void applicationTest() {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] matrix2 = new int[][]{{1, 3}, {1, 3}, {1, 3}};
        var application = new MatrixMultiplicationApplication();
        Assertions.assertDoesNotThrow(() -> application.start(matrix1, matrix2));
    }

    @Test
    public void outputTest() {
        int[][] matrix1 = new int[][]{{2, 2, 2}, {2, 2, 3}, {1, 2, 3}};
        int[][] matrix2 = new int[][]{{1, 3}, {1, 3}, {1, 3}};
        int[][] expected = new int[][]{{6, 18}, {7, 21}, {6, 18}};
        var application = new MatrixMultiplicationApplication();
        Assertions.assertTrue(() -> {
                    try {
                        int[][] result = application.start(matrix1, matrix2);
                        if (result.length!=expected.length) {
                            return false;
                        }
                        for (int i = 0; i < result.length; i++) {
                            for (int j = 0; j < result[0].length; j++) {
                                if (result[i][j]!=expected[i][j]) {
                                    return false;
                                }
                            }
                        }
                    } catch (NonMultiplicativeMatrixException | InterruptedException e) {
                        Assertions.fail();
                    }
                    return true;
                }
        );
    }

    @Test
    public void nonMultiplicableMatricesTest() {
        int[][] matrix1 = new int[][]{{2, 2, 2}, {2, 2, 3}, {1, 2, 3}}; //Can't be multiplied because M1 has 3 columns but M2 has only 2 rows
        int[][] matrix2 = new int[][]{{1, 3}, {1, 3}};
        var application = new MatrixMultiplicationApplication();
        Assertions.assertThrows(NonMultiplicativeMatrixException.class, () -> application.start(matrix1, matrix2));
    }
}
