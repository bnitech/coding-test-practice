package com.bnitech.kotlin.programmers

fun 롤케이크자르기(topping: IntArray): Int {
    var answer = 0
    for (knife in topping.indices) {
        val setA = mutableSetOf<Int>()
        val setB = mutableSetOf<Int>()

        for (a in 0..knife) {
            setA.add(topping[a])
        }
        for (b in knife + 1 until topping.size) {
            setB.add(topping[b])
            if (setA.size < setB.size) {
                break
            }
        }

        if(setA.size == setB.size){
            answer++
        }
    }

    return answer
}