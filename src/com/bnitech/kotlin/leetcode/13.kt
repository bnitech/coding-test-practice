package com.bnitech.kotlin.leetcode

val match = mapOf<Char?, Int?>('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

fun romanToInt(s: String): Int {
    var sum = 0;
    var before = ' ';
    for (c: Char in s) {
        if(c == 'V' || c == 'X'){
            if(before == 'I'){
                sum -= match[before]!!.toInt() * 2
            }
        }

        if(c == 'L' || c == 'C'){
            if(before == 'X'){
                sum -= match[before]!!.toInt() * 2
            }
        }

        if(c == 'D' || c == 'M'){
            if(before == 'C'){
                sum -= match[before]!!.toInt() * 2
            }
        }

        sum += match[c]!!.toInt()
        before = c;
    }
    return sum;
}

