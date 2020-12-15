package com.bnitech.acmicpc.Q_2193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)   throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());
        long[][] memo = new long[numN + 1][2];
        memo[1][1] = 1;
        if (numN == 1) {
        }
        for (int N = 2; N <= numN; N++) {
            for (int K = 0; K <= 1; K++) {
                if(K==0){
                    memo[N][K] += memo[N-1][0];
                    memo[N][K] += memo[N-1][1];
                }else{
                    memo[N][K] += memo[N-1][0];
                }
            }
        }
        System.out.println(memo[numN][0] + memo[numN][1]);

    }
}
