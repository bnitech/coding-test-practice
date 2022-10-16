package com.bnitech.java.leetcode;

public class Pair<F, R> {
    private F front;
    private R rear;

    public Pair(F front, R rear) {
        this.front = front;
        this.rear = rear;
    }

    public F getFront() {
        return front;
    }

    public R getRear() {
        return rear;
    }
}
