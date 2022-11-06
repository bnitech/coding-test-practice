package com.bnitech.kotlin

import com.bnitech.kotlin.programmers.우박수열정적분

fun main() {
    val result = 우박수열정적분(
        5,
        arrayOf(intArrayOf(0, 0), intArrayOf(0, -1), intArrayOf(2, -3), intArrayOf(3, -3))
    )
    println(result.joinToString { it.toString() })
}
