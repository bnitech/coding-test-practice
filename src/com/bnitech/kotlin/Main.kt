package com.bnitech.kotlin

import com.bnitech.kotlin.leetcode.mostVisitedPattern

fun main() {
    val result = mostVisitedPattern(
        arrayOf("joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"),
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
        arrayOf("home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career")
    )
    println(result)
}
