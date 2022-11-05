package com.bnitech.kotlin.programmers

import java.util.*

data class Light(var y: Int, var x: Int, var dir: Dir, var length: Int)

enum class Dir(val y: Int, val x: Int) {
    RIGHT(0, 1), DOWN(1, 0), UP(-1, 0), LEFT(0, -1),
}

fun 빛의경로사이클(grid: Array<String>): IntArray {
    val dirs = arrayOf(Dir.RIGHT, Dir.DOWN, Dir.LEFT, Dir.UP)
    val map = ArrayList<CharArray>()
    val answer = ArrayList<Int>()
    for (i in grid.indices) {
        map.add(grid[i].toCharArray())
    }
    val check = Array(grid.size) { Array(grid[0].length) { BooleanArray(4) } }

    val queue: Queue<Light> = LinkedList()
    for (row in map.indices) {
        for (col in map[0].indices) {
            for(d in dirs.indices) {
                queue.offer(Light(row, col, dirs[d], 0))
                while (!queue.isEmpty()) {
                    val cur = queue.poll()
                    if (check[cur.y][cur.x][cur.dir.ordinal]) {
                        answer.add(cur.length)
                        continue
                    }

                    val next = Light(cur.y, cur.x, cur.dir, cur.length + 1)

                    when (map[cur.y][cur.x]) {
                        'L' -> {
                            when (cur.dir) {
                                Dir.RIGHT -> next.dir = Dir.UP
                                Dir.DOWN -> next.dir = Dir.RIGHT
                                Dir.UP -> next.dir = Dir.LEFT
                                Dir.LEFT -> next.dir = Dir.DOWN
                            }
                        }

                        'R' -> {
                            when (cur.dir) {
                                Dir.RIGHT -> next.dir = Dir.DOWN
                                Dir.DOWN -> next.dir = Dir.LEFT
                                Dir.UP -> next.dir = Dir.RIGHT
                                Dir.LEFT -> next.dir = Dir.UP
                            }
                        }
                    }

                    when (next.dir) {
                        Dir.RIGHT -> {
                            if (cur.x == map[0].size - 1) next.x = 0
                            else next.x = cur.x + 1
                        }

                        Dir.DOWN -> {
                            if (cur.y == map.size - 1) next.y = 0
                            else next.y = cur.y + 1
                        }

                        Dir.LEFT -> {
                            if (cur.x == 0) next.x = map[0].size - 1
                            else next.x = cur.x - 1
                        }

                        Dir.UP -> {
                            if (cur.y == 0) next.y = map.size - 1
                            else next.y = cur.y - 1
                        }
                    }

                    check[cur.y][cur.x][cur.dir.ordinal] = true
                    queue.offer(next)
                }
            }
        }
    }
    return answer.filter { i: Int -> i != 0 }.sorted().toIntArray()
}