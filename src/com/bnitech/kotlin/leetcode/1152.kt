package com.bnitech.kotlin.leetcode

data class Log(val time: Int, val name: String, val website: String)

fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
    val logs = arrayListOf<Log>()
    for (i in timestamp.indices) {
        logs.add(Log(timestamp[i], username[i], website[i]))
    }
    logs.sortWith(Comparator { a, b -> a.time.compareTo(b.time) })

    val visitedWebsites = mutableMapOf<String, ArrayList<String>>()
    for (log in logs) {
        val list = visitedWebsites.getOrDefault(log.name, arrayListOf())
        list.add(log.website)
        visitedWebsites[log.name] = list
    }

    val score = mutableMapOf<String, Set<String>>()
    for (user in visitedWebsites.keys) {
        val websites = visitedWebsites[user]!!
        val listSize = websites.size

        for (i in 0 until listSize - 2) {
            for (j in i + 1 until listSize - 1) {
                for (k in j + 1 until listSize) {
                    val key = websites[i] + " " + websites[j] + " " + websites[k]
                    score[key] = score.getOrDefault(key, mutableSetOf()).plus(user)
                }
            }
        }
    }

    val result = score.toList().sortedWith(Comparator { a, b ->
        if (a.second.size == b.second.size) a.first.compareTo(b.first) else a.second.size.compareTo(b.second.size) * -1
    })[0]

    return result.first.split(" ")
}