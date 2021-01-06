package com.bnitech.leetcode.Q_655;

import com.bnitech.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 655. Print Binary Tree
public class Solution {
    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);

        String[][] res = new String[height][(1 << height) - 1];

        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        List<List<String>> ans = new ArrayList<>();

        fill(res, root, 0, 0, res[0].length);

        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }

        return ans;
    }

    private static void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.val;
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
