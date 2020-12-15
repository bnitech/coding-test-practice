package com.bnitech.acmicpc.Q_2442;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        for (int i = 1; i <= numN; i++) {
            for (int j1 = 1; j1 <= numN - i; j1++) {
                System.out.print(" ");
            }
            for (int j2 = 1; j2 <= (i * 2) - 1; j2++) {
                System.out.print("*");
            }
            if (i != numN) System.out.println();
        }
    }
}
