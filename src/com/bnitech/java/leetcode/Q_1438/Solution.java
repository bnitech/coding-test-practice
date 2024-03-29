package com.bnitech.java.leetcode.Q_1438;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
public class Solution {
    public static int longestSubarray(final int[] nums, final int limit) {
        int length = nums.length;

        // {value, size}
        int[] max = {0, 0};
        for (int front = 0; front < length; front++) {
            for (int rear = front; rear < length; rear++) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < rear - front + 1; i++) {
                    list.add(nums[front + i]);
                }
                int diff = Collections.max(list) - Collections.min(list);
                if (diff <= limit) {
                    if (diff == max[0]) {
                        max[1] = Math.max(max[1], list.size());
                    } else if (diff > max[0]) {
                        max[0] = diff;
                        max[1] = list.size();
                    }
                }
            }
        }
        return max[1];
    }
}
