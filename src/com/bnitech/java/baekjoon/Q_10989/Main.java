/*
정렬-정렬-수 정렬하기 3
 */

package com.bnitech.acmicpc.Q_10989;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        int[] cnt_N = new int[10001];
        for (int i = 0; i < num_N; i++) {
            cnt_N[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000 ; i++) {
            if(cnt_N[i]>0) {
                for (int j = 0; j < cnt_N[i]; j++) {
                    System.out.println(i);                }
            }
        }
    }
}
