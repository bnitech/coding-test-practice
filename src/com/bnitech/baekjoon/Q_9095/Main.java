package com.bnitech.acmicpc.Q_9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numT = Integer.parseInt(br.readLine());
        int[] memo = new int[20];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        int minIndex = 3;
        while (numT-->0){
            int numN = Integer.parseInt(br.readLine());
            if(minIndex < numN) {
                for (int i = minIndex+1; i <= numN; i++) {
                    memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
                }
                minIndex = numN;
            }
            System.out.println(memo[numN]);
        }
    }
}
