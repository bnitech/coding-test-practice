package com.bnitech.kotlin.baekjoon

/*
10 2
.L
..
XX
XX
XX
XX
XX
XX
..
.L
 */

/*
8 17
...XXXXXX..XX.XXX
....XXXXXXXXX.XXX
...XXXXXXXXXXXX..
..XXXXX.LXXXXXX..
.XXXXXX..XXXXXX..
XXXXXXX...XXXX...
..XXXXX...XXX....
....XXXXX.XXXL...
 */

import java.util.*

data class Point_labudovi(val y: Int, val x: Int, val time: Int) : Comparable<Point_labudovi> {
    override fun compareTo(other: Point_labudovi): Int {
        return this.time.compareTo(other.time)
    }
}

val dirY = intArrayOf(-1, 0, 1, 0)
val dirX = intArrayOf(0, 1, 0, -1)
val waterQueue = PriorityQueue<Point_labudovi>()
val swans = arrayListOf<Point_labudovi>()

fun labudovi() {
    val br = System.`in`.bufferedReader()
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val lake = Array<Array<Char>>(R) { Array<Char>(C) { '@' } }
    val timeLake = Array<Array<Int>>(R) { Array<Int>(C) { Int.MAX_VALUE } }
    val waterVisited = Array<Array<Boolean>>(R) { Array<Boolean>(C) { false } }
    val swanVisited = Array<Array<Boolean>>(R) { Array<Boolean>(C) { false } }

    for (r in 0 until R) {
        val cArr = br.readLine().toCharArray()
        for (c in 0 until C) {
            lake[r][c] = cArr[c]

            if (cArr[c] == '.') {
                waterQueue.offer(Point_labudovi(r, c, 0))
                timeLake[r][c] = 0
            } else if (cArr[c] == 'L') {
                swans.add(Point_labudovi(r, c, 0))
                waterQueue.offer(Point_labudovi(r, c, 0))
                timeLake[r][c] = 0
                waterVisited[r][c] = true
            }
        }
    }
//    printMultiArr("lake", lake)
//    print("waterQueue", waterQueue)
//    print("swans", swans)

    while (waterQueue.isNotEmpty()) {
        val water = waterQueue.poll()

        for (d in 0 until 4) {
            val nextDY = water.y + dirY[d]
            val nextDX = water.x + dirX[d]
            val nextTime = water.time + 1

            if (nextDY < 0 || nextDX >= C || nextDY >= R || nextDX < 0) {
                continue
            }

            if (waterVisited[nextDY][nextDX]) {
                continue
            }

            if (lake[nextDY][nextDX] == 'X') {
//                println("$nextDY:$nextDX = ${lake[nextDY][nextDX]}")
//                printMultiArr("timeLake", timeLake)

                if (timeLake[nextDY][nextDX] > nextTime) {
                    timeLake[nextDY][nextDX] = nextTime
                    waterQueue.offer(Point_labudovi(nextDY, nextDX, nextTime))
                    waterVisited[nextDY][nextDX] = true
                }
            }

        }
    }

    val moveQueue = PriorityQueue<Point_labudovi>()
    moveQueue.offer(swans[1])
    swanVisited[swans[1].y][swans[1].x] = true

    while (moveQueue.isNotEmpty()) {
        val swan = moveQueue.poll()
//        print("moveQueue", moveQueue)
//        println("swan: $swan")
//        printMultiArr("timeLake", timeLake)

        if (swans[0].y == swan.y && swans[0].x == swan.x) {
            println(swan.time)
            return
        }

        for (d in 0 until 4) {
            val nextDY = swan.y + dirY[d]
            val nextDX = swan.x + dirX[d]

            if (nextDY < 0 || nextDX >= C || nextDY >= R || nextDX < 0) {
                continue
            }

            if (swanVisited[nextDY][nextDX]) {
                continue
            }

//            println("$nextDY:$nextDX = ${timeLake[nextDY][nextDX]}")

            swanVisited[nextDY][nextDX] = true
            if (timeLake[nextDY][nextDX] > swan.time) {
                moveQueue.offer(Point_labudovi(nextDY, nextDX, timeLake[nextDY][nextDX]))
            } else {
                moveQueue.offer(Point_labudovi(nextDY, nextDX, swan.time))
            }
        }
    }

    println(Int.MAX_VALUE)
    return
}
