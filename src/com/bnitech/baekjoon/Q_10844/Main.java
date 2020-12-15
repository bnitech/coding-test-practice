package com.bnitech.acmicpc.Q_10844;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());
        int[][] memoStep = new int[numN + 1][11];
        for (int i = 1; i <= 9 ; i++) {
            memoStep[1][i]=1;
        }
        for (int n = 1; n <= numN; n++) {
            for (int k = 0; k <= 9; k++) {
                if(k-1>=0) memoStep[n][k] += memoStep[n - 1][k - 1];
                memoStep[n][k] += memoStep[n - 1][k + 1];
                memoStep[n][k] %= 1000000000;
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9 ; i++) {
            sum+=memoStep[numN][i];
        }
        System.out.print(sum%1000000000);
    }
}
