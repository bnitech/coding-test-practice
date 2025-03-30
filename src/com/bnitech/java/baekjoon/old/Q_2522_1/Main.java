package com.bnitech.acmicpc.Q_2522_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        int start = 1, end = numN * 2 - 1;
        int emptyCount = numN - 1, starCount = 1;
        int emptyUnit = -1, starUnit = 1;
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= emptyCount; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= starCount; j++) {
                System.out.print("*");
            }
            if (i == numN) {
                emptyUnit *= -1;
                starUnit *= -1;
            }
            emptyCount += emptyUnit;
            starCount += starUnit;

            if (i != end) System.out.println();
        }
    }
}
