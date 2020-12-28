package com.bnitech;

import com.bnitech.leetcode.Q_54.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> integerList = Solution.spiralOrder(matrix);
        integerList.forEach(System.out::print);
    }
}
