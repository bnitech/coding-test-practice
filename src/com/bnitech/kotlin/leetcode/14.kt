package com.bnitech.kotlin.leetcode

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs[0].isBlank()) {
        return ""
    }

    val sb = StringBuilder()
    for (i in strs[0].indices) {
        sb.append(strs[0][i])
        for (str in strs) {
            if (str.length < sb.length || sb[sb.lastIndex] != str[i]) {
                sb.delete(sb.lastIndex, sb.lastIndex + 1)
                return sb.toString()
            }
        }
    }

    return ""
}