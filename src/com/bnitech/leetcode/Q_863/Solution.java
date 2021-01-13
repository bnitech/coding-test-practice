package com.bnitech.leetcode.Q_863;

import com.bnitech.leetcode.Pair;
import com.bnitech.leetcode.TreeNode;

import java.util.*;

// 863. All Nodes Distance K in Binary Tree
public class Solution {

    // {key, value{left, right, parent}}
    public static Map<Integer, int[]> graph;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        graph = new HashMap<>();
        makeGraphByDfs(root, null);

        Set<Integer> visitedNode = new HashSet<>();

        // {me, depth}
        Queue<Pair<Integer, Integer>> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(new Pair<>(target.val, 0));

        List<Integer> valueList = new ArrayList<>();

        while (!treeNodeQueue.isEmpty()) {
            Pair<Integer, Integer> pair = treeNodeQueue.poll();
            int nodeValue = pair.getFront();
            int depth = pair.getRear();

            if (nodeValue < 0) continue;

            if (!visitedNode.add(nodeValue)) continue;

            if (depth == K) {
                valueList.add(nodeValue);
                continue;
            }

            for (int i : graph.get(nodeValue)) {
                treeNodeQueue.offer(new Pair<>(i, depth + 1));
            }
        }

        return valueList;
    }

    private static void makeGraphByDfs(TreeNode me, TreeNode parent) {
        if (me == null) return;

        // {left, right, parent}
        int[] values = new int[]{-1, -1, -1};

        if (me.left != null) {
            values[0] = me.left.val;
            makeGraphByDfs(me.left, me);
        }

        if (me.right != null) {
            values[1] = me.right.val;
            makeGraphByDfs(me.right, me);
        }

        if (parent != null) {
            values[2] = parent.val;
        }

        graph.put(me.val, values);
    }
}