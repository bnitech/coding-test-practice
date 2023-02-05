package com.bnitech.kotlin.baekjoon

fun 곱셈() {
    val br = System.`in`.bufferedReader()
    val (A, B, C) = br.readLine().split(" ").map { it.toInt() }
    println(pow(A.toLong(), B, C))
}

fun pow(A: Long, exponent: Int, modC: Int): Long {
    if (exponent == 1) {
        return A % modC
    }

    val tmp = pow(A, exponent / 2, modC)

    if (exponent % 2 == 1) {
        return (tmp * tmp % modC) * A % modC
    }

    return tmp * tmp % modC
}
