package com.bnitech.java;

import com.bnitech.java.leetcode.Q_207.Solution;

public class Main {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{2, 0}, {3, 2}, {3, 0}, {3, 1}, {4, 1}, {5, 2}, {5, 3}, {5, 4}};
        boolean result = Solution.canFinish(6, prerequisites);
        System.out.println(result);
    }
}
