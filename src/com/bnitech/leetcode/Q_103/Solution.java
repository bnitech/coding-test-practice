package com.bnitech.leetcode.Q_103;

import com.bnitech.leetcode.Pair;
import com.bnitech.leetcode.TreeNode;

import java.util.*;

// 103. Binary Tree Zigzag Level Order Traversal
public class Solution {
    private static final int TO_RIGHT = 0, TO_LEFT = 1;

    public static List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<List<Integer>> valueListList = new ArrayList<>();
        valueListList.add(Collections.singletonList(root.val));

        Queue<Pair<TreeNode, Integer>> pairQueue = new LinkedList<>();
        pairQueue.offer(new Pair<>(root, TO_LEFT));

        while (!pairQueue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = pairQueue.poll();
            TreeNode currentTreeNode = currentPair.getFront();
            if(currentTreeNode == null) continue;
            int currentDir = currentPair.getRear();

            if (currentTreeNode.left == null && currentTreeNode.right == null) {
                continue;
            }

            List<Integer> valueList = new ArrayList<>();

            if (currentDir == TO_RIGHT) {
                if (currentTreeNode.left != null) {
                    valueList.add(currentTreeNode.left.val);
                    pairQueue.offer(new Pair<>(currentTreeNode.left, TO_LEFT));
                }
                if (currentTreeNode.right != null) {
                    valueList.add(currentTreeNode.right.val);
                    pairQueue.offer(new Pair<>(currentTreeNode.right, TO_LEFT));
                }
            } else {
                if (currentTreeNode.right != null) {
                    valueList.add(currentTreeNode.right.val);
                    pairQueue.offer(new Pair<>(currentTreeNode.right, TO_RIGHT));
                }
                if (currentTreeNode.left != null) {
                    valueList.add(currentTreeNode.left.val);
                    pairQueue.offer(new Pair<>(currentTreeNode.left, TO_RIGHT));
                }
            }

            if (valueList.size() > 0) valueListList.add(valueList);
        }

        return valueListList;
    }
}
