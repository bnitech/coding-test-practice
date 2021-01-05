package com.bnitech.leetcode.Q_111;

import java.util.LinkedList;

// 111. Minimum Depth of Binary Tree
public class Solution {

    public static int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            queue.add(new Pair<>(root, 1));
        }

        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getFront();
            depth = current.getRear();
            if ((root.left == null) && (root.right == null)) {
                break;
            }
            if (root.left != null) {
                queue.add(new Pair<>(root.left, depth + 1));
            }
            if (root.right != null) {
                queue.add(new Pair<>(root.right, depth + 1));
            }
        }
        return depth;
    }

    static class Pair<F, R> {
        F front;
        R rear;

        public Pair(F front, R rear) {
            this.front = front;
            this.rear = rear;
        }

        public F getFront() {
            return front;
        }

        public R getRear() {
            return rear;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


