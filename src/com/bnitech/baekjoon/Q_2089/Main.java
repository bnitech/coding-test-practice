/*
수학-Base Conversion- -2진수
 */

package com.bnitech.acmicpc.Q_2089;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        StringBuilder sb_N = new StringBuilder();

        if (num_N == 0) {
            System.out.println(0);
            return;
        }
        while (num_N != 0) {
            if (num_N % 2 == 0) {
                num_N = -(num_N / 2);
                sb_N.insert(0, '0');
            } else {
                if (num_N > 0) {
                    num_N = -(num_N / 2);
                } else {
                    num_N = (-num_N + 1) / 2;
                }
                    sb_N.insert(0, '1');
            }
        }
        System.out.println(sb_N.toString());
    }
}
