/*
그래프-연결 요소-연결 요소의 개수
 */

package com.bnitech.acmicpc.Q_11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_V = Integer.parseInt(st.nextToken());
        int num_E = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arrLIst_V = new ArrayList[num_V+1];
        for (int i = 1; i <= num_V ; i++) {
            arrLIst_V[i] = new ArrayList<>();
        }

        for (int i = 0; i <num_E ; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            arrLIst_V[V1].add(V2);
            arrLIst_V[V2].add(V1);
        }

        int count_CC = 0;

        boolean check_BFS[] = new boolean[num_V+1];
        for (int i = 1; i <=num_V ; i++) {

            if(check_BFS[i]) continue;
            else count_CC++;

            int start_V = i;

            Queue<Integer> queue_V = new LinkedList<>();
            queue_V.offer(start_V);
            check_BFS[start_V] = true;

            while (queue_V.isEmpty()==false){
                int poll_V = queue_V.poll();
                for (int V: arrLIst_V[poll_V]) {
                    if(check_BFS[V]==false){
                        queue_V.offer(V);
                        check_BFS[V] = true;
                    }
                }
            }

        }

        System.out.println(count_CC);

    }
}
