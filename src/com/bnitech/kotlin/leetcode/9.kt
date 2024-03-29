package com.bnitech.kotlin.leetcode

fun isPalindrome(x: Int): Boolean {
    if(x < 0) return false
    val str = x.toString()

    var front = -1;
    var rear = str.length;
    while (++front <= --rear){
        if(str[front] != str[rear]) return false;
    }
    return true;
}