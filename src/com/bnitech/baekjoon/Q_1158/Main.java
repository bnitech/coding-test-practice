package com.bnitech.acmicpc.Q_1158;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {

        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        int numM = input.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();


        for (int i = 0; i < numN; i++) {
            list.add(i+1);
        }
        int index = 0;
        System.out.print("<");
        while (numN > 0) {
            index += numM-1;
            if (index >= list.size()) {
                index %= list.size();
            }
            if (numN == 1) {
                System.out.print(list.get(index) + ">");
            } else {
                System.out.print(list.get(index) + ", ");
            }
            list.remove(index);
            numN--;
        }

    }
}
