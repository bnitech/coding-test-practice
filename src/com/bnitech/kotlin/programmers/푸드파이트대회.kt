package com.bnitech.kotlin.programmers

import java.lang.StringBuilder

fun 푸드파이트대회(food: IntArray): String {
    val sb = StringBuilder()
    for (i in 1 until food.size) {
        repeat(food[i] / 2) { sb.append('0' + i) }
    }

    val suffix = sb.toString().reversed()
    sb.append('0')
    sb.append(suffix)

    return sb.toString()
}