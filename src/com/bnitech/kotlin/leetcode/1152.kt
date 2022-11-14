package com.bnitech.kotlin.leetcode

fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
    val visitedWebsites = mutableMapOf<String, ArrayList<String>>()
    for (i in timestamp.indices) {
        val list = visitedWebsites.getOrDefault(username[i], arrayListOf())
        list.add(website[i])
        visitedWebsites[username[i]] = list
    }

    val score = mutableMapOf<String, Int>()
    for (user in visitedWebsites.keys) {
        val websites = visitedWebsites[user]!!
        val listSize = websites.size
        for (i in 0 until listSize - 2) {
            for (j in i + 1 until listSize - 1) {
                for (k in j + 1 until listSize) {
                    val key = websites[i] + " " + websites[j] + " " + websites[k]
                    score[key] = score.getOrDefault(key, 0) + 1
                }
            }
        }
    }

    val result = score.toList().sortedWith { a, b ->
        if (a.second == b.second) a.first.compareTo(b.first) else a.second.compareTo(b.second) * -1
    }[0]

    return result.first.split(" ")
}