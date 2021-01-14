package com.bnitech.leetcode.Q_207;

import java.util.*;

// 207. Course Schedule
public class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> childListMap = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // prerequisite[0] -> prerequisite[1]
        for (int[] prerequisite : prerequisites) {
            childListMap.compute(prerequisite[1], (key, valueList) -> {
                inDegree[prerequisite[0]]++;

                if (valueList == null) valueList = new ArrayList<>();
                valueList.add(prerequisite[0]);

                return valueList;
            });
        }

        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) nodeQueue.offer(i);
        }

        while (!nodeQueue.isEmpty()) {
            int node = nodeQueue.poll();
            inDegree[node]--;

            List<Integer> childList = childListMap.getOrDefault(node, Collections.emptyList());
            childList.forEach(childNode -> inDegree[childNode]--);

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    nodeQueue.offer(i);
                }
            }
        }

        for (int j : inDegree) {
            if (j >= 0) return false;
        }

        return true;
    }
}
