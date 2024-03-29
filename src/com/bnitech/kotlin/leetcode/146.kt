package com.bnitech.kotlin.leetcode

import java.util.*


data class LRUCache(val capacity: Int) {
    private var lru: MutableMap<Int, Info> = mutableMapOf()

    fun get(key: Int): Int {
        addLruTime()
        return lru[key]?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        addLruTime()
        if (isFull() && !lru.containsKey(key)) {
            evictInfo()
        }
        lru[key] = Info(value)
    }

    private fun isFull(): Boolean {
        return lru.size >= capacity
    }


    private fun evictInfo() {
        var targetKey = -1;
        var maxTime = 0
        for (entry in lru.entries) {
            if (maxTime < entry.value.time) {
                targetKey = entry.key
                maxTime = entry.value.time
            }
        }
        lru.remove(targetKey)
    }

    private fun addLruTime() {
        for (info in lru.values) {
            info.addTime()
        }
    }

    class Info(value: Int) {

        val value: Int = value
            get() {
                this.time = 0
                return field
            }

        var time: Int = 0
            private set

        fun addTime() {
            time++
        }
    }

    fun printList() {
        lru.values.forEach { info -> print("(${info.value},${info.time}),") }
        println("\n===")
    }
}
