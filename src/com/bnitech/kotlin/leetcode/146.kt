package com.bnitech.kotlin.leetcode

import java.util.*

data class LRUCache(val capacity: Int) {
    private val times: Array<Int> = Array(capacity) { 0 }
    private val arr: Array<Pair<Int, Int>> = Array(capacity) { Pair(-1, -1) }

    fun get(key: Int): Int {
        var value: Int = -1
        for ((i, pair: Pair<Int, Int>) in arr.withIndex()) {
            times[i] = times[i] + 1
            if (pair.first == key) {
                times[i] = 0
                value = pair.second
            }
        }

        return value
    }

    fun put(key: Int, value: Int) {
        val result = get(key)
        if (result != -1) {
            for ((i, pair: Pair<Int, Int>) in arr.withIndex()) {
                if (pair.first == key) {
                    arr[i] = Pair(key, value)
                    return
                }
            }
        }

        var max = 0
        var index = 0
        if (arr.size >= capacity) {
            for ((i, time: Int) in times.withIndex()) {
                if (max < time) {
                    index = i
                    max = time
                }
            }
        }

        arr[index] = Pair(key, value)
        times[index] = 0
    }

    fun printList() {
        times.forEach { time -> print("${time},") }
        println()
        arr.forEach { pair -> print("${pair},") }
        println("\n===")
    }
}
