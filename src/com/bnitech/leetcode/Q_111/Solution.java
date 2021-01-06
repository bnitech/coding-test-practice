package com.bnitech.leetcode.Q_111;

import com.bnitech.leetcode.Pair;
import com.bnitech.leetcode.TreeNode;

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
}


