package com.bnitech.kotlin.utils

import java.util.Queue

fun <T> printMultiArr(name: String, arr: Array<Array<T>>) {
    println("=== $name ===")
    arr.forEachIndexed { index, element ->
        println("$index: ${element.contentDeepToString()}")
    }
    println("======\n")
}

fun <T> print(name: String, list: Collection<T>) {
    println("=== $name ===")
    list.forEachIndexed { index, element ->
        println("$index: ${element.toString()}")
    }
    println("======\n")
}
