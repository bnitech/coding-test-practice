package com.bnitech;

import com.bnitech.leetcode.Q_1438.Solution;

public class Main {

    public static void main(String[] args) {
        int[] input = {24, 12, 71, 33, 5, 87, 10, 11, 3, 58, 2, 97, 97, 36, 32, 35, 15, 80, 24, 45, 38, 9, 22, 21, 33, 68, 22, 85, 35, 83, 92, 38, 59,
                90, 42, 64, 61, 15, 4, 40, 50, 44, 54, 25, 34, 14, 33, 94, 66, 27, 78, 56, 3, 29, 3, 51, 19, 5, 93, 21, 58, 91, 65, 87, 55, 70, 29, 81,
                89, 67, 58, 29, 68, 84, 4, 51, 87, 74, 42, 85, 81, 55, 8, 95, 39};
        int[] input1 = {4,2,2,2,4,4,2,2};
        int result = Solution.longestSubarray(input, 87);
        System.out.println(result);
    }
}
