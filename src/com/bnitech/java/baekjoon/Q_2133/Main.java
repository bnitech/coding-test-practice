package com.bnitech.acmicpc.Q_2133;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
            int count[] = new int[num + 1];
            count[0] = 1;
            count[1] = 0;
            for (int i = 2; i <= num; i++) {
                count[i] += count[i - 2] * 3;
                for (int j = 4; j <= i; j += 2) {
                    count[i] += count[i - j] * 2;
                }
        }
        System.out.println(count[num]);
    }
}
