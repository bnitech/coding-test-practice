package com.bnitech.leetcode.Q1277;

// 1277
public class Solution1 {
    /*
    [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]

  [1,0,1],
  [1,1,0],
  [1,1,0]
     */

    public static int countSquares(final int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    for (int size = 0; size <= i; size++) {
                        if (isSquare(matrix, i, j, size)) count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isSquare(final int[][] matrix, int m, int n, int size) {
        for (int k = m; k >= m - size; k--) {
            for (int l = n; l >= n - size; l--) {
                if (k < 0 || l < 0 || matrix[k][l] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}