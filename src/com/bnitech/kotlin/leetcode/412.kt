package com.bnitech.kotlin.leetcode

fun fizzBuzz(n: Int): List<String> {
    val result = arrayListOf<String>()
    for(i in 1 .. n) {
        var str = ""
        if (i % 3 == 0) {
            str += "Fizz"
        }
        if (i % 5 == 0) {
            str += "Buzz"
        }

        if(str.isBlank()){
            str = i.toString()
        }

        result.add(str)
    }
    return result
}