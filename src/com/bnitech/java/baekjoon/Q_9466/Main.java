/*
그래프-사이클 찾기-텀 프로젝트
 */
package com.bnitech.acmicpc.Q_9466;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int arr_N[];
    static int check_N[];
    static int count_no_join_N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num_T = Integer.parseInt(br.readLine());
        while (num_T-- > 0) {

            int num_N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr_N = new int[num_N + 1];

            //0 방문 안합, 1 방문합, 2 방문하고 사이클에 속함
            check_N = new int[num_N + 1];

            count_no_join_N = 0;

            for (int i = 1; i <= num_N; i++) {
                int choice_N = Integer.parseInt(st.nextToken());
                arr_N[i] = choice_N;
                if (i == choice_N) {
                    check_N[i] = 1;
                }
            }


            for (int i = 1; i <=num_N; i++) {
                int start_N = i;
                if (check_N[start_N] != 0) continue;

                int deep = 1;
                check_N[start_N] =deep;
                int result = DFS(start_N,deep);
                if(result!=0) count_no_join_N+=check_N[result];
            }

            System.out.println(count_no_join_N);

        }
    }
    public static int DFS(int cur_N, int deep){
        int next_N = arr_N[cur_N];
        int last_N =cur_N;

        if(check_N[next_N]==0) {
            check_N[next_N]=deep+1;
            last_N = DFS(next_N, deep+1);
        }else {
            return cur_N;
        }

        if(cur_N == arr_N[last_N]){
            count_no_join_N += check_N[cur_N]-1;
            return 0;
        }else{
            return last_N;
        }
    }

}
