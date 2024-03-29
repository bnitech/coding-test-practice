package com.bnitech.kotlin.baekjoon

import kotlin.math.max

data class Product(val weight: Int, val value: Int)

fun 평범한_배낭(): Int {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }

    val products = mutableListOf<Product>()

    repeat(N) {
        val (W, V) = br.readLine().toString().split(" ").map { it.toInt() }
        products.add(Product(W, V))
    }

    br.close()

    val dp = Array(N) { Array(K + 1) { 0 } }
    for (w in 0..K) {
        if (products[0].weight <= w) {
            dp[0][w] = products[0].value
        }
    }

    for (i in 1 until N) {
        for (w in 0..K) {
            if (products[i].weight <= w) {
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - products[i].weight] + products[i].value)
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }

    return dp[N - 1][K]
}