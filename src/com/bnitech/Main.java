package com.bnitech;

import com.bnitech.leetcode.Q_48.Solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2}, {3, 4, 5}, {1, 3, 1}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        Solution.rotate(matrix);
        System.out.println("======= result ========");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
