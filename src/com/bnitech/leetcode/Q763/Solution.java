package com.bnitech.leetcode.Q763;

import java.util.*;

public class Solution {
    public static List<Integer> partitionLabels(final String S) {
        // char : Index
        HashMap<Character, Integer> letterMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            letterMap.put(S.charAt(i), i);
        }

        LinkedList<Integer> indexList = new LinkedList<>();
        int endIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            int letterIndex = letterMap.get(S.charAt(i));
            if (endIndex < letterIndex) {
                endIndex = letterIndex;
            }

            if (i == endIndex) {
                indexList.add(i);
                endIndex = 0;
            }
        }

        List<Integer> sizeList = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            if (i == 0) {
                sizeList.add(indexList.get(i) + 1);
            } else
                sizeList.add(indexList.get(i) - indexList.get(i - 1));
        }

        return sizeList;
    }
}