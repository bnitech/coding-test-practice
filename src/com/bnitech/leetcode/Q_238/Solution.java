package com.bnitech.leetcode.Q_238;

// 238. Product of Array Except Self
public class Solution {
    public static int[] productExceptSelf(final int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;
        for (int i = 1; i < output.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int tmp = 1;
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = output[i] * tmp;
            tmp = tmp * nums[i];
        }

        return output;
    }
}
