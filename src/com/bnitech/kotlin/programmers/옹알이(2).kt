package com.bnitech.kotlin.programmers

fun 옹알이2(babbling: Array<String>): Int {
    val words = arrayOf("aya", "ye", "woo", "ma")
    var temp = babbling.toMutableList();

    var answer: Int = 0
    for (i in temp.indices) {
        for (j in words.indices) {
            if (temp[i].isNotBlank()) {
                temp[i] = temp[i].replace(words[j], j.toString())
            }
        }
    }
    for (str in temp) {
        var success = true
        for (i in str.indices) {
            if (str[i] !in '0'..'3') {
                success = false
                break
            }
            if (i + 1 < str.length && str[i] == str[i + 1]) {
                success = false
                break
            }

        }
        if (success) {
            answer++
        }
    }

    return answer
}