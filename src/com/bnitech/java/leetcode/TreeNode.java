package com.bnitech.java.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTreeNode(final TreeNode currentTreeNode, final Integer[] input, final int idx) {
        currentTreeNode.val = input[idx];

        int leftIdx = idx * 2 + 1, rightIdx = idx * 2 + 2;
        if (leftIdx < input.length && input[leftIdx] != null) {
            currentTreeNode.left = createTreeNode(new TreeNode(), input, leftIdx);
        }
        if (rightIdx < input.length && input[rightIdx] != null) {
            currentTreeNode.right = createTreeNode(new TreeNode(), input, rightIdx);
        }

        return currentTreeNode;
    }
}
