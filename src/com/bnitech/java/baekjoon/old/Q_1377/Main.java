/*
정렬-정렬 응용하기-버블 소트
 */

package com.bnitech.acmicpc.Q_1377;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        int arr_N[][] = new int[num_N][2];
        for (int i = 0; i < num_N ; i++) {
            arr_N[i][0] = Integer.parseInt(br.readLine());
            arr_N[i][1] = i;
        }
        Arrays.sort(arr_N,(int[] num1,int[] num2)->Integer.compare(num1[0],num2[0]));

        int max = 0;
        for (int i = 0; i <num_N ; i++) {
            if(arr_N[i][1]-i > max){
                max = arr_N[i][1]-i;
            }
        }
        System.out.println(max+1);
    }

}
