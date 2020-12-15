/*
그래프-그래프 탐색-DFS와 BFS
 */

package com.bnitech.acmicpc.Q_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static ArrayList<Integer>[] arrayList_V;
    public static boolean check_V[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_V = Integer.parseInt(st.nextToken());
        int num_E = Integer.parseInt(st.nextToken());
        int start_V = Integer.parseInt(st.nextToken());

        arrayList_V = new ArrayList[num_V + 1];
        for (int i = 1; i <= num_V; i++) {
            arrayList_V[i] = new ArrayList<>();
        }

        for (int i = 0; i < num_E; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            arrayList_V[V1].add(V2);
            arrayList_V[V2].add(V1);
        }
        for (int i = 1; i <= num_V; i++) {
            Collections.sort(arrayList_V[i]);
        }

        check_V = new boolean[num_V + 1];
        DFS(start_V);

        System.out.println();

        check_V = new boolean[num_V + 1];
        BFS(start_V);

    }


    public static void DFS(int V) {
        if (check_V[V]) return;
        check_V[V] = true;
        System.out.print(V + " ");
        for (int num_V : arrayList_V[V]) {
            if (check_V[num_V] == false) DFS(num_V);
        }
    }


    public static void BFS(int V){
        Queue<Integer> quere_V = new LinkedList<>();
        quere_V.offer(V);
        System.out.print(V + " ");
        check_V[V] = true;
        while (quere_V.isEmpty() == false) {
            int num_V = quere_V.poll();
            for (int input_V : arrayList_V[num_V]) {
                if (check_V[input_V] == false) {
                    quere_V.offer(input_V);
                    System.out.print(input_V + " ");
                    check_V[input_V] = true;
                }
            }
        }
    }
}
