package com.bnitech.leetcode.Q_1277;

// 1277
public class Solution2 {
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
        int[][] dp = matrix.clone();

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += dp[i][j];
            }
        }

        return count;
    }
}