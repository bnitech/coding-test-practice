/*
수학-펙토리얼 0의 개수-팩토리얼 0의 개수
 */

package com.bnitech.acmicpc.Q_1676;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());

        int count_5 =0;
        for (int i = 5; i <= num_N ; i*=5) {
            count_5 += num_N/i;
        }
        System.out.println(count_5);
    }
}