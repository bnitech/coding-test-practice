package com.bnitech;

import com.bnitech.leetcode.Q1423.Solution;

public class Main {

    public static void main(String[] args) {
        int[] input = {9,7,7,9,7,7,9};
        int k = 7;
        int score = Solution.maxScore(input, k);
        System.out.println(score);
    }
}
