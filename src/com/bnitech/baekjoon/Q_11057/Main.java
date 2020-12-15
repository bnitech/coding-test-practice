package com.bnitech.acmicpc.Q_11057;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());
        int[][] memoStep = new int[numN+1][10];
        for (int K = 0; K <= 9; K++) {
            memoStep[1][K]++;
        }
        for (int N = 2; N <= numN; N++) {
            for (int K = 0; K <= 9; K++) {
                for (int L = 0; L <= K; L++) {
                    memoStep[N][K] += memoStep[N - 1][L] % 10007;
                }
            }
        }
        long sum = 0;
        for (int j = 0; j <= 9; j++) {
            sum += memoStep[numN][j] % 10007;
        }

        System.out.println(sum);
    }
}
