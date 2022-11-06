package com.bnitech.kotlin.programmers

fun 우박수열정적분(k: Int, ranges: Array<IntArray>): DoubleArray {
    var su = k
    var suY = ArrayList<Int>()
    var area = ArrayList<Double>()
    var suX = 0
    suY.add(su)
    area.add(0.0)
    while (su > 1) {
        suX++

        if (su % 2 == 0) {
            su /= 2
        } else {
            su = su * 3 + 1
        }

        suY.add(su)
        area.add(
            area[suX-1] + calculArea(suX-1, suX, suY[suX-1], suY[suX])
        )
    }

    var answer = ArrayList<Double>(ranges.size)
    for(i in ranges.indices){
        val start = ranges[i][0]
        val end = suX + ranges[i][1]
        if(start>end){
            answer.add(-1.0)
            continue
        }

        answer.add(area[end] - area[start])
    }

    return answer.toDoubleArray()
}

fun calculArea(x1: Int, x2: Int, y1: Int, y2: Int): Double {
    return (y1 + y2) * (x2 - x1) / 2.0
}