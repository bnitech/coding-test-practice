package com.bnitech.leetcode.Q_217;

import java.util.Arrays;

// 217. Contains Duplicate
public class Solution1 {
    public static boolean containsDuplicate(final int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
