package com.bnitech.acmicpc.Q_10799;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        char[] chars = input.next().toCharArray();
        int count = 0;
        int top = 0;
        int size = 0;
        for (char c : chars) {
            if (c == '(') {
                top++;
                size = top;
                count++;
            } else if (c == ')') {
                top--;
                size--;
                //레이저로 발사
                if (size >= 0) {
                    count--;
                    while (size-- >= 1) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
