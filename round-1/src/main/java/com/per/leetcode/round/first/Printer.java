package com.per.leetcode.round.first;

/**
 * @author Xavier
 * @date 2025/3/10 09:14
 */
public class Printer {

    public static void printMatrix(int[][] matrix) {
        System.out.println("----------------------:len=" + matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\n");
            }
            System.out.println();
        }
    }
}
