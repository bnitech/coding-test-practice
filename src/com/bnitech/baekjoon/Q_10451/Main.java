/*
그래프-사이클 찾기-순열 사이클
 */

package com.bnitech.acmicpc.Q_10451;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_T = Integer.parseInt(br.readLine());
        while (num_T-- >0) {
            int num_V = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr_V = new int[num_V+1];
            for (int i = 1; i <= num_V; i++) {
                arr_V[i] = Integer.parseInt(st.nextToken());
            }

            int check_V[] = new int[num_V + 1];
            int count_cycle=0;

            for (int i = 1; i <= num_V; i++) {
                int start_V = i;
                if (check_V[start_V] != 0) continue;

                check_V[start_V] = 1;
                count_cycle++;

                int next_V = arr_V[start_V];
                while (next_V!=0){
                    if (check_V[next_V]!=0) break;

                    check_V[next_V] = 1;
                    next_V = arr_V[next_V];
                }
            }

            System.out.println(count_cycle);
        }
    }
}
