package com.bnitech.acmicpc.Q_9461;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        long sum[] = new long[100 + 1];

        for (int i = 1; i <= 100; i++) {
            if (i == 1) sum[i] = 1;
            else if (i == 2) sum[i] = 1;
            else if (i == 3) sum[3] = 1;
            else if (i == 4) sum[4] = 2;
            else sum[i] = sum[i - 5] + sum[i - 1];
        }

        for (int i = 0; i <tcase ; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(sum[num]);
        }
    }
}
