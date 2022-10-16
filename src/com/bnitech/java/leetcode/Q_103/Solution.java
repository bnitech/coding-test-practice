package com.bnitech.java.leetcode.Q_103;

import com.bnitech.java.leetcode.TreeNode;

import java.util.*;

// 103. Binary Tree Zigzag Level Order Traversal
public class Solution {
    private static final int TO_RIGHT = 0, TO_LEFT = 1;

    public static List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> valueListList = new ArrayList<>();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        int depth = 0;
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();

            List<Integer> valueList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode == null) continue;

                valueList.add(treeNode.val);
                treeNodeQueue.offer(treeNode.left);
                treeNodeQueue.offer(treeNode.right);
            }

            if (!valueList.isEmpty()) {
                if (depth % 2 == TO_LEFT) {
                    Collections.reverse(valueList);
                }
                valueListList.add(valueList);
            }

            depth++;
        }

        return valueListList;
    }
}
