/*
정렬=정렬-수 정력하기2
 */

package com.bnitech.acmicpc.Q_2751;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        int[] arr_N = new int[num_N];
        for (int i = 0; i <num_N ; i++) {
            arr_N[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr_N);


        for (int i = 0; i <num_N ; i++) {
            System.out.println(arr_N[i]);
        }
    }
}

