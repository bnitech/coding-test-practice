package com.bnitech;

import com.bnitech.leetcode.Q_238.Solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] results = Solution.productExceptSelf(input);
        Arrays.stream(results).forEach(System.out::println);
    }
}
