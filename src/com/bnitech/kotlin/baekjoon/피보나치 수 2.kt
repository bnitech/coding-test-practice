package com.bnitech.kotlin.baekjoon

fun 피보나치_수_2(): Long {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val dp = Array<Long>(N + 1) { 0 }

    dp[1] = 1

    for (i in 2..N) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[N]
}