/*
그래프-사이클 찾기-반복수열
 */

package com.bnitech.acmicpc.Q_2331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_A = Integer.parseInt(st.nextToken());
        int num_P = Integer.parseInt(st.nextToken());

        int max_N = 1000000;
        int check_N[] = new int[max_N+1];

        int count = 1;
        int next_A = num_A;

        while (check_N[next_A]==0){
            ;
            check_N[next_A] = count++;

            String str_A = String.valueOf(next_A);
            int len_A = str_A.length();
            int sum_A = 0;
            for (int i = 0; i < len_A ; i++) {
                int num_su = (str_A.charAt(i)-'0');
                int sum_su = num_su;
                for (int j = 0; j <num_P-1; j++) {
                    sum_su*= num_su;
                }
                sum_A += sum_su;
            }
            next_A = sum_A;
        }

        System.out.println(check_N[next_A]-1);

    }
}
