package com.bnitech.acmicpc.Q_2011;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charSu = br.readLine().toCharArray();
        int mod = 1000000;
        int len = charSu.length;
        int[] su = new int[len + 1];
        long memo[] = new long[len + 1];
        memo[0]=1;
        for (int i = 1; i <= len; i++) {
            su[i] = charSu[i - 1] - '0';
            if (1 <= su[i] && su[i] <= 9) {
                memo[i] = (memo[i] + memo[i - 1]) % mod;
            }
            int tmpSu = su[i - 1] * 10 + su[i];
            if (10 <= tmpSu && tmpSu <= 26) {
                memo[i] = (memo[i] + memo[i - 2]) % mod;
            }
        }

        System.out.println(memo[len]);
    }
}
