/*
그래프-플러드 필-섬의 개수
 */

package com.bnitech.acmicpc.Q_4963;

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

        int num_W = Integer.parseInt(st.nextToken());
        int num_H = Integer.parseInt(st.nextToken());

        while (num_W != 0 || num_H != 0) {

            int[][] arr_N = new int[1 + num_H + 1][1 + num_W + 1];

            //      i = Y , j = X
            for (int i = 1; i <= num_H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= num_W; j++) {
                    arr_N[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count_N = 0;

//            우, 하, 좌, 상, 우상, 우하, 좌하, 좌상
            int dy[] = {0, 1, 0, -1, -1, 1, 1, -1};
            int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};

            for (int i = 1; i <= num_H; i++) {
                for (int j = 1; j <= num_W; j++) {
                    int start_i = i, start_j = j;
                    if (arr_N[start_i][start_j] == 0) continue;

                    Queue<Point> queue_N = new LinkedList<>();
                    queue_N.offer(new Point(start_i, start_j));
                    arr_N[start_i][start_j] = 0;

                    while (queue_N.isEmpty() == false) {
                        Point poll_point = queue_N.poll();
                        start_i = poll_point.Y;
                        start_j = poll_point.X;

//                      우, 하, 좌, 상, 우상, 우하, 좌하, 좌상
                        for (int k = 0; k <8 ; k++) {
                            if (arr_N[start_i+dy[k]][start_j+dx[k]] != 0) {
                                queue_N.offer(new Point(start_i+dy[k], start_j + dx[k]));
                                arr_N[start_i+dy[k]][start_j + dx[k]] = 0;
                            }
                        }

                    }
                    count_N++;
                }
            }


            System.out.println(count_N);

            st = new StringTokenizer(br.readLine());

            num_W = Integer.parseInt(st.nextToken());
            num_H = Integer.parseInt(st.nextToken());
        }

    }
}

class Point {
    int Y;
    int X;

    Point(int Y, int X) {
        this.Y = Y;
        this.X = X;
    }
}
