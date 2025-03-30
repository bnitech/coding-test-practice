/*
정렬-정렬 응용하기-K번째 수
 */

package com.bnitech.acmicpc.Q_11004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num_N = Integer.parseInt(st.nextToken());
        int num_K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr_N = new int[num_N];
        for (int i = 0; i <num_N ; i++) {
            arr_N[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_N);

        System.out.println(arr_N[num_K-1]);
    }
}
