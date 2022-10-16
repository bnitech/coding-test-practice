package com.bnitech.java.leetcode.Q_217;

import java.util.HashSet;
import java.util.Set;

// 217. Contains Duplicate
public class Solution2 {
    public static boolean containsDuplicate(final int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (final int num : nums) {
            if (integerSet.contains(num)) return true;
            integerSet.add(num);
        }
        return false;
    }
}
