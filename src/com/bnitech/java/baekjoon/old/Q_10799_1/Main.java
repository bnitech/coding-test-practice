package com.bnitech.acmicpc.Q_10799_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        char[] pipes = input.next().toCharArray();
        int count = 0;
        int top = 0;
        for (int i = 0; i < pipes.length; i++) {
            if (pipes[i] == '(' && pipes[i + 1] == ')') { // ������ �߻�
                count = count + top;
                i = i + 1;
            } else if (pipes[i] == '(') { // �踷�� �߰�
                top = top + 1;

            } else if (pipes[i] == ')') { // �踷�� ����
                top = top - 1;
                count = count + 1;
            }
        }
        System.out.println(count);
    }
}
