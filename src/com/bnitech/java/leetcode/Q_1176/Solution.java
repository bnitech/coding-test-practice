package com.bnitech.java.leetcode.Q_1176;

// 1176. Diet Plan Performance
public class Solution {
    public static int dietPlanPerformance(final int[] calories, final int k, final int lower, final int upper) {
        int point = 0;
        for (int i = 0; i < calories.length - k + 1; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                if (i + j >= calories.length) break;

                sum += calories[i + j];
            }

            if (sum < lower) point--;
            if (sum > upper) point++;
        }
        return point;
    }
}
