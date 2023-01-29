package com.bnitech.kotlin.baekjoon

fun 피보나치_수_5(): Int {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()

    return F(num)
}

fun F(num: Int): Int {
    if (num <= 0) {
        return 0
    }

    if (num == 1) {
        return 1
    }

    return F(num - 1) + F(num - 2)
}