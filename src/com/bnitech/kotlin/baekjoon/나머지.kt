package com.bnitech.kotlin.baekjoon

fun 나머지(){
    val br = System.`in`.bufferedReader()
    val lineArr = br.readLine().split(" ")
    val A = lineArr[0].toInt()
    val B = lineArr[1].toInt()
    val C = lineArr[2].toInt()

    println((A+B)%C)
    println(((A%C)+(B%C))%C)
    println((A*B)%C)
    println(((A%C)*(B%C))%C)
}