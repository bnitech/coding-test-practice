package com.bnitech.acmicpc.Q_10991;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        for (int i = 1; i <= numN; i++) {
            for (int empty = numN - i; empty >= 1; empty--) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 1+(i-1)*2; star ++) {
                if (star % 2 == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            if (i != numN * 2 - 1) System.out.println();
        }
    }
}
