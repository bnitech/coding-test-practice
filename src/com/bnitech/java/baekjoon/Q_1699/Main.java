package com.bnitech.acmicpc.Q_1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            count[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (count[i] > count[i - j * j] + 1) {
                    count[i] = count[i - j * j] + 1;
                }
            }
        }
        System.out.println(count[num]);
    }
}
