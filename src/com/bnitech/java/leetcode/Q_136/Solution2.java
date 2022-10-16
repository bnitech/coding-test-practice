package com.bnitech.java.leetcode.Q_136;

import java.util.HashSet;
import java.util.Set;

// 136. Single Number
public class Solution2 {
    public static int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) numSet.remove(num);
            else numSet.add(num);
        }
        return numSet.iterator().next();
    }
}
