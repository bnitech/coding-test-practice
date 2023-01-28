package com.bnitech.kotlin.baekjoon

/**
7
1
5
2
10
-99
7
5
 */

import java.lang.StringBuilder
import java.util.*

fun 가운데를_말해요() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val sb = StringBuilder()

    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    val minHeap = PriorityQueue<Int>()

    for (i in 0 until N) {
        val su = br.readLine().toInt()

        if (maxHeap.size == minHeap.size) {
            maxHeap.add(su)
        } else {
            minHeap.add(su)
        }

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            if (maxHeap.peek() > minHeap.peek()) {
                val tmp = minHeap.poll()
                minHeap.add(maxHeap.poll())
                maxHeap.add(tmp)
            }
        }

        sb.append("${maxHeap.peek()}\n")
    }

    println(sb)
}
