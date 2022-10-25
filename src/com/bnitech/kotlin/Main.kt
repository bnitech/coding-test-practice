package com.bnitech.kotlin

import com.bnitech.kotlin.leetcode.LRUCache

fun main() {
    val cache = LRUCache(2)

    cache.put(1, 1)
    cache.printList()

    cache.put(2, 2)
    cache.printList()

    cache.get(1)
    cache.printList()

    cache.put(3, 3)
    cache.printList()

    cache.get(2)
    cache.printList()

    cache.put(4,4)
    cache.printList()

    cache.get(1)
    cache.printList()

    cache.get(3)
    cache.printList()

    cache.get(4)
    cache.printList()
}
