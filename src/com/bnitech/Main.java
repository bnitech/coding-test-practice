package com.bnitech;

import com.bnitech.leetcode.Q_863.Solution;
import com.bnitech.leetcode.TreeNode;

import java.util.List;

public class Main {

    public static Integer[] input = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.createTreeNode(new TreeNode(), input, 0);

        List<List<String>> tree = com.bnitech.leetcode.Q_655.Solution.printTree(treeNode);
        tree.forEach(System.out::println);
        System.out.println("============================");

        List<Integer> list = Solution.distanceK(treeNode, new TreeNode(5), 2);
        System.out.println(list);
    }


}
