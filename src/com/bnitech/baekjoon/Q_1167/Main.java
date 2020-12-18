/*
트리-트리의 지름-트리의 지름
 */
package com.bnitech.baekjoon.Q_1167;

//import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static  int num_V;
    public static ArrayList<Node>[] arr_V;
    public static int[] count_dis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num_V = Integer.parseInt(br.readLine());

        arr_V = new ArrayList[num_V + 1];
        count_dis = new int[num_V+1];
        for (int i = 1; i <= num_V; i++) {
            arr_V[i] = new ArrayList<>();
        }
        for (int i = 1; i <= num_V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int V = Integer.parseInt(st.nextToken());
                if(V==-1) break;
                int dis = Integer.parseInt(st.nextToken());

                arr_V[node].add(new Node(V,dis));
            }
        }
        int start_V = 1;
        BFS(start_V);

        //출발지에서 제일 먼곳부터 다시 반대로 한 번 더 탐색함 ( 출발지에 도착하는 노드들과의 거리 계산)
        for (int i = 1; i <=num_V ; i++) {
            if(count_dis[i] > count_dis[start_V]){
                start_V = i;
            }
        }

        count_dis[start_V] = 0;
        BFS(start_V);


        int max_dis =0;
        for (int dis : count_dis) {
            if(max_dis < dis) max_dis = dis;
        }
        System.out.println(max_dis);

    }
    static void BFS(int start_V){
        Queue<Node> queue_V = new LinkedList<>();
        int[] check_V = new int[num_V+1];

        queue_V.offer(new Node(start_V,0));
        check_V[start_V] = 1;

        while (queue_V.isEmpty() == false){
            Node poll_node = queue_V.poll();
            start_V =poll_node.V;
            count_dis[start_V] = poll_node.dis;

            for(Node next_node : arr_V[start_V]) {
                if(check_V[next_node.V] == 1) continue;
                queue_V.offer(new Node(next_node.V,next_node.dis+poll_node.dis));
                check_V[next_node.V] = 1;
            }
        }
    }

    static class Node {
        int V, dis;

        public Node(int V, int dis) {
            this.V = V;
            this.dis = dis;
        }
    }
}

