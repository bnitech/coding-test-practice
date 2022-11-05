package com.bnitech.kotlin.programmers

fun 야간전술보행(distance: Int, scope: Array<IntArray>, times: Array<IntArray>): Int {
    val answer = ArrayList<Int>()

    val peopleCount = scope.size
    for (index in 0 until peopleCount) {
        val onTime = times[index][0] + times[index][1]

        scope[index].sort()

        val startScope = scope[index][0]
        val endScope = scope[index][1]

        for (time in startScope..endScope) {
            if(time % onTime > 0 && time % onTime <= times[index][0]) {
                answer.add(time)
                break
            }
        }
    }

    if(answer.isEmpty()){
        return distance
    }

    answer.sort()
    return answer[0]
}