package com.bnitech.java.programmers;

import java.util.Deque;
import java.util.LinkedList;

public class SkillCheck4 {

    public static int[] priorities = {2, 1, 3, 2};
    public static int[] priorities_1 = {1, 1, 9, 1, 1, 1};
    public static int location = 0;

    public static int solution(int[] priorities, int location) {
        Deque<PageInfo> delayQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            delayQueue.addLast(new PageInfo(priorities[i], i == location));
        }

        int countPrintNum = 0;
        while (!delayQueue.isEmpty()) {
            PageInfo targetPageInfo = delayQueue.pollFirst();

            boolean isMax = true;
            for (PageInfo pageInfo : delayQueue) {
                if (targetPageInfo.priority < pageInfo.priority) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                countPrintNum++;
                if (targetPageInfo.isTarget) {
                    break;
                }
            } else {
                delayQueue.addLast(targetPageInfo);
            }
        }

        return countPrintNum;
    }

    public static class PageInfo {

        int priority = 0;
        boolean isTarget = false;

        public PageInfo(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }
    }

    public static String s = "aabbaccc";
    public static String s_1 = "ababcdcdababcdcd";
    public static String s_2 = "xababcdcdababcdcd";

    public static int solution2(String s) {

        int minLen = Integer.MAX_VALUE;
        for (int offset = 1; offset <= s.length() / 2; offset++) {
            StringBuilder sbResult = new StringBuilder();
            int front = 0;
            int rear = front + offset;
            String targetStr = s.substring(front, rear);
            int countNum = 0;
            while (rear <= s.length()) {
                if (targetStr.equals(s.substring(front, rear))) {
                    countNum++;
                } else {
                    if (countNum <= 1) {
                        sbResult.append(targetStr);
                    } else {
                        sbResult.append(countNum).append(targetStr);
                    }
                    targetStr = s.substring(front, rear);
                    countNum = 1;
                }

                front += offset;
                rear += offset;

                if (front > s.length() || rear > s.length()) {
                    if (countNum <= 1) {
                        sbResult.append(targetStr);
                    } else {
                        sbResult.append(countNum).append(targetStr);
                    }
                    sbResult.append(s.substring(front));
                }
            }

            if (minLen > sbResult.length()) {
                minLen = sbResult.length();
            }
        }

        return minLen;
    }
}
