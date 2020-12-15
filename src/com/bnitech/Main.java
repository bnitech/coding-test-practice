package com.bnitech;

import com.bnitech.leetcode.Q763.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = "ababcbacadefegdehijhklij";
        List<Integer> result = Solution.partitionLabels(input);
        System.out.println(result);
    }
}
