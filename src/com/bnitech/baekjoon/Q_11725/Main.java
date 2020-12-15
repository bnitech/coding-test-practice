/*
트리의 탐색-트리의 부모 찾기
 */

package com.bnitech.acmicpc.Q_11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr_V = new ArrayList[num_N + 1];

        for (int i = 1; i <= num_N; i++) {
            arr_V[i] = new ArrayList();
        }

        for (int i = 0; i < num_N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr_V[A].add(B);
            arr_V[B].add(A);
        }

        int[] check_V = new int[num_N + 1];
        int[] parent_V = new int[num_N + 1];

        int start_V = 1;

        Queue<Integer> queue_V = new LinkedList<>();
        queue_V.offer(start_V);
        check_V[1] = 1;

        while (queue_V.isEmpty()==false) {
            int poll_V = queue_V.poll();

            for (int V : arr_V[poll_V]) {
                if(check_V[V]==1)continue;
                queue_V.offer(V);
                check_V[V] = 1;
                parent_V[V] = poll_V;
            }
        }
        for (int i = 2; i <=num_N ; i++) {
            System.out.println(parent_V[i]);
        }
    }
}
