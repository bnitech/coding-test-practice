package com.bnitech.kotlin.programmers

fun 햄버거만들기(ingredient: IntArray): Int {
    val sb = StringBuilder()
    var answer = 0
    for (i in ingredient.indices) {
        sb.append('0' + ingredient[i])
        if (sb.length >= 4 && sb.substring(sb.length - 4).equals("1231")){
            sb.setLength(sb.length -4)
            answer++
        }
    }
    return answer
}