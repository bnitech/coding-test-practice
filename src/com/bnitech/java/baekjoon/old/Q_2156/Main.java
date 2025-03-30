package com.bnitech.acmicpc.Q_2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numN = Integer.parseInt(br.readLine());
        int[][] memo = new int[numN + 1][3];
        memo[1][1] = Integer.parseInt(br.readLine());
        //memo[1][0]
        for (int N = 2; N <= numN; N++) {
            int podoju = Integer.parseInt(br.readLine());
            memo[N][0] = 0 + Math.max(Math.max(memo[N - 1][0], memo[N - 1][1]), memo[N - 1][2]);
            memo[N][1] = podoju + memo[N - 1][0];
            memo[N][2] = podoju + memo[N - 1][1];
        }
        System.out.println(Math.max(Math.max(memo[numN][0], memo[numN][1]), memo[numN][2]));
    }
}
