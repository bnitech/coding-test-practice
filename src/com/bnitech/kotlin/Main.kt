package com.bnitech.kotlin

import com.bnitech.kotlin.programmers.빛의경로사이클

fun main() {
    val result = 빛의경로사이클(arrayOf("SL","LR"))
    result.forEach { i: Int ->  print("${i}, ") }
}
