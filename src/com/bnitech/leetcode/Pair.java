package com.bnitech.leetcode;

public class Pair<F, R> {
    F front;
    R rear;

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
