/*
그래프-이분 그래프-이분 그래프
 */


package com.bnitech.acmicpc.Q_1707;

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

        int num_T = Integer.parseInt(st.nextToken());

        while (num_T-- > 0) {

            st = new StringTokenizer(br.readLine());

            int num_V = Integer.parseInt(st.nextToken());
            int num_E = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] arrLIst_V = new ArrayList[num_V + 1];
            for (int i = 1; i <= num_V; i++) {
                arrLIst_V[i] = new ArrayList<>();
            }

            for (int i = 0; i < num_E; i++) {
                st = new StringTokenizer(br.readLine());
                int V1 = Integer.parseInt(st.nextToken());
                int V2 = Integer.parseInt(st.nextToken());

                arrLIst_V[V1].add(V2);
                arrLIst_V[V2].add(V1);
            }


            int[] check_V = new int[num_V + 1];
            boolean isOK = true;

            for (int i = 1; i <= num_V; i++) {
                int start_V = i;
                if(check_V[start_V]!=0) continue;

                int part_V = 1;

                Queue<Integer> queue_V = new LinkedList<>();
                queue_V.offer(start_V);
                check_V[start_V] = part_V;


                while (queue_V.isEmpty() == false && isOK) {
                    int poll_V = queue_V.poll();
                    part_V = check_V[poll_V];

                    for (int V : arrLIst_V[poll_V]) {
                        if (check_V[V] == 0) {
                            queue_V.offer(V);
                            check_V[V] = part_V*(-1);
                        } else if(check_V[V]==check_V[poll_V]) {
                            isOK = false;
                            break;
                        }
                    }
                }
            }
            if (isOK)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
