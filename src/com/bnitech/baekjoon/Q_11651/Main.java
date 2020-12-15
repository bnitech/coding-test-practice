/*
정렬-정렬-좌표정렬하기2
 */

package com.bnitech.acmicpc.Q_11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        int[][] arr_N = new int[num_N][2];
        StringTokenizer st;
        for (int i = 0; i < num_N; i++) {
            st = new StringTokenizer(br.readLine());
            arr_N[i][0] = Integer.parseInt(st.nextToken());
            arr_N[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_N,(int[] o1,int[] o2)->{
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < num_N; i++) {
            System.out.println(arr_N[i][0] +" "+ arr_N[i][1]);
        }

    }
}
