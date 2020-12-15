package com.bnitech.acmicpc.Q_2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().result();
    }

    public void result() {

        Scanner input = new Scanner(System.in);
        int numN = input.nextInt();
        int numK = input.nextInt();
        int dis = Math.abs(numN - numK);

        int[] moveMinCount = new int[dis+1];
        for (int i = 1; i <=dis ; i++) {
            int tmp = i;

        }
    }
}
