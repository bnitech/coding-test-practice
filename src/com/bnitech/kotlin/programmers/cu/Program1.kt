package com.bnitech.kotlin.programmers.cu

fun cu_program1(arr: IntArray, n: Int): Boolean {
    for (i in arr.indices) {
        if (arr[i] >= n) {
            continue
        }

        for (j in i + 1 until arr.size) {
            if (arr[j] > n - arr[i]) {
                continue
            }

            if (arr[i] + arr[j] == n) {
                return true
            }
        }
    }

    return false
}