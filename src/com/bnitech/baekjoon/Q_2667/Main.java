/*
그래프-플러드 필-단지번호붙이기
 */

package com.bnitech.acmicpc.Q_2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_N = Integer.parseInt(br.readLine());
        int[][] arr_N = new int[1+num_N+1][1+num_N+1];

//      i = Y , j = X
        for (int i = 1; i <=num_N ; i++) {
            String str_N = br.readLine();
            for (int j = 1; j <=num_N ; j++) {
                arr_N[i][j] = (str_N.charAt(j-1)-'0');
            }
        }

        ArrayList<Integer> arrLIst_count_N = new ArrayList<>();

        for (int i = 1; i <=num_N ; i++) {
            for (int j = 1; j <=num_N ; j++) {
                int start_i = i, start_j = j;
                if(arr_N[start_i][start_j]==0)continue;

                Queue<Point> queue_N = new LinkedList<>();
                queue_N.offer(new Point(start_i,start_j));
                arr_N[start_i][start_j] = 0;
                int count_N =0;

                while (queue_N.isEmpty()==false) {
                    Point poll_point = queue_N.poll();
                    start_i = poll_point.Y;
                    start_j = poll_point.X;

                    count_N++;

                    if (arr_N[start_i][start_j + 1] != 0) {
                        queue_N.offer(new Point(start_i, start_j + 1));
                        arr_N[start_i][start_j + 1] = 0;
                    }
                    if (arr_N[start_i + 1][start_j] != 0) {
                        queue_N.offer(new Point(start_i + 1, start_j));
                        arr_N[start_i + 1][start_j] = 0;
                    }
                    if (arr_N[start_i][start_j - 1] != 0) {
                        queue_N.offer(new Point(start_i, start_j - 1));
                        arr_N[start_i][start_j - 1] = 0;
                    }
                    if (arr_N[start_i - 1][start_j] != 0) {
                        queue_N.offer(new Point(start_i - 1, start_j));
                        arr_N[start_i - 1][start_j] = 0;
                    }

                }

                arrLIst_count_N.add(count_N);
            }
        }
        Collections.sort(arrLIst_count_N);
        System.out.println(arrLIst_count_N.size());
        for(int num : arrLIst_count_N){
            System.out.println(num);
        }
    }
}
class Point{
    int Y;
    int X;
    Point(int Y,int X){
        this.Y = Y;
        this.X = X;
    }
}
