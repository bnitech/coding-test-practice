package com.bnitech.kotlin.programmers.cu

fun cu_program2(A: IntArray, S: Int): Int {
    var min = Int.MAX_VALUE;
    for (i in A.indices) {
        if (A[i] >= S) {
            return 1
        }

        var sum = A[i]
        var count = 1

        for (j in i + 1 until A.size) {
            sum += A[j]
            count++

            if (count >= min) {
                break
            }

            if (sum >= S) {
                if (min > count) {
                    min = count
                }
                break
            }
        }
    }

    return if (min == Int.MAX_VALUE) 0 else min
}