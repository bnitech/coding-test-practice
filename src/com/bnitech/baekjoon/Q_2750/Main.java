package com.bnitech.acmicpc.Q_2750;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i <numN ; i++) {
            list.add(input.nextInt());
        }
        Collections.sort(list);

        for (int output:list) {
            System.out.println(output);
        }
    }
}
