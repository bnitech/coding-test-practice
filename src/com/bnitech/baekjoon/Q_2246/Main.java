package com.bnitech.acmicpc.Q_2246;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().result();
    }

    public void result() {
        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();

        for (int i = 1; i <= numN; i++) {

            for (int empty = 1; empty <= (i - 1); empty++) {
                System.out.print(" ");
            }
            for (int star = 1 + ((numN - i) * 2); star >= 1; star--) {
                System.out.print("*");
            }

            System.out.println();
        }
        for(int i = numN-1; i >= 1; i--){
            for(int empty = i-1; empty >=1; empty--){
                System.out.print(" ");
            }
            for(int star = 1; star <= 1 + (numN-i)*2; star++){
                System.out.print("*");
            }
            if(i!=1) System.out.println();
        }
    }
}
