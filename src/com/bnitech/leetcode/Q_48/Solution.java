package com.bnitech.leetcode.Q_48;

// 48. Rotate Image
public class Solution {
    public static void rotate(int[][] matrix) {
        final int size = matrix.length;
        int[][] matrix2 = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix2[j][(size - i - 1)] = matrix[i][j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = matrix2[i][j];
            }
        }
    }
}
