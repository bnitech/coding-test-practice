package com.bnitech.leetcode.Q_1423;

// 1423. Maximum Points You Can Obtain from Cards
public class Solution {

    //[1,2,3,4,5,6,1], k = 3

    public static int maxScore(int[] cardPoints, int k) {

        int sum = 0, score = 0, length = cardPoints.length;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        score = sum;

        for (int i = 0; i < k; i++) {
            sum -= cardPoints[(k - 1) - i];
            sum += cardPoints[(length - 1) - i];

            score = Math.max(score, sum);
        }

        return score;
    }
}
