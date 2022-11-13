package com.bnitech.kotlin.leetcode

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }

    if (s.length == 1) {
        return 1
    }

    var front = 0
    var rear = 0
    var maxLength = 1

    var subString = s.substring(front, rear + 1)
    while (++rear < s.length) {
        val nextChar = s[rear]
        while (subString.contains(nextChar) && front <= rear) {
            subString = s.substring(++front, rear)
        }

        subString = s.substring(front, rear + 1)
        if (maxLength < subString.length) {
            maxLength = subString.length
        }
    }

    return maxLength
}