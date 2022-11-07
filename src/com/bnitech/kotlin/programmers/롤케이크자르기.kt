package com.bnitech.kotlin.programmers

fun 롤케이크자르기(topping: IntArray): Int {
    var answer = 0
    var toppingNums = Array(topping.max() + 1) { 0 }
    val setA = mutableSetOf<Int>()
    val setB = topping.toMutableSet()

    topping.forEach { toppingNums[it]++ }

    for (knife in topping.indices) {
        val digit = topping[knife]
        setA.add(digit)
        toppingNums[digit]--
        if(toppingNums[digit] <= 0){
            setB.remove(digit)
        }

        if (setA.size == setB.size) {
            answer++
        }
    }

    return answer
}