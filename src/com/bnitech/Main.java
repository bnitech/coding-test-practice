package com.bnitech;

import com.bnitech.leetcode.Q_103.Solution;
import com.bnitech.leetcode.TreeNode;

import java.util.List;

public class Main {

    public static Integer[] input = {1,2,3,4,null,null,5};

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.createTreeNode(new TreeNode(), input, 0);

        List<List<String>> tree = com.bnitech.leetcode.Q_655.Solution.printTree(treeNode);
        tree.forEach(System.out::println);
        System.out.println("============================");

        List<List<Integer>> listList = Solution.zigzagLevelOrder(treeNode);
        listList.forEach(System.out::println);

    }


}
