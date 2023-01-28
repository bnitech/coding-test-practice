package com.bnitech.kotlin.baekjoon

/**
13
0
1
2
0
0
3
2
1
0
0
0
0
0
 */

import java.util.PriorityQueue

fun 최대_힙() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    for (i in 0 until N) {
        val su = br.readLine().toInt()
        if (su == 0) {
            if(maxHeap.isEmpty()){
                println(0)
                continue
            }
            println(maxHeap.poll())
        } else {
            maxHeap.add(su)
        }
    }
}
