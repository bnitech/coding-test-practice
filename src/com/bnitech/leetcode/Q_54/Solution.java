package com.bnitech.leetcode.Q_54;

import java.util.ArrayList;
import java.util.List;

// 54. Spiral Matrix
public class Solution {

    public static List<Integer> spiralOrder(final int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0, dir = 0;

        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
                dir++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                dir++;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                dir++;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }
        }

        return list;
    }
}
