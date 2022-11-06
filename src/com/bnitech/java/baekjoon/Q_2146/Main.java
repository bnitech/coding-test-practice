/*
그래프-플러드 필-다리 만들기
 */

package com.bnitech.acmicpc.Q_2146;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num_N = Integer.parseInt(br.readLine());

        int[][] arr_N = new int[1 + num_N + 1][1 + num_N + 1];
        int[][] land = new int[1 + num_N + 1][1 + num_N + 1];
        int[][] count_dis = new int[1 + num_N + 1][1 + num_N + 1];

        for (int i = 1; i <= num_N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num_N; j++) {
                arr_N[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//      우, 하, 좌, 상
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};


        Queue<Point> queue_N = new LinkedList<>();

        //섬 구별하기
        int kind_land = 0;

        for (int i = 1; i <= num_N; i++) {
            for (int j = 1; j <= num_N; j++) {
                int start_i = i;
                int start_j = j;

                if (arr_N[start_i][start_j] == 1 && land[start_i][start_j] == 0) {

                    queue_N.offer(new Point(start_i, start_j));

                    kind_land++;
                    land[start_i][start_j] = kind_land;

                    while (queue_N.isEmpty() == false) {
                        Point poll_point = queue_N.poll();
                        start_i = poll_point.Y;
                        start_j = poll_point.X;

                        for (int k = 0; k < 4; k++) {
                            int next_i = start_i + dy[k];
                            int next_j = start_j + dx[k];

                            if (arr_N[next_i][next_j] == 1 && land[next_i][next_j] == 0) {
                                queue_N.offer(new Point(next_i, next_j));
                                land[next_i][next_j] = kind_land;
                            }
                        }
                    }
                }
            }
        }

        //거리 맵 초기화
        for (int i = 1; i <= num_N; i++) {
            for (int j = 1; j <= num_N; j++) {
                count_dis[i][j] = -1;
                if (land[i][j] > 0) {
                    queue_N.offer(new Point(i, j));
                    count_dis[i][j] = 0;
                }
            }
        }

        //거리 측정 && 섬 확장
        while (queue_N.isEmpty() == false) {
            Point poll_point = queue_N.poll();
            int start_i = poll_point.Y;
            int start_j = poll_point.X;

//              우, 하, 좌, 상
            for (int k = 0; k < 4; k++) {
                int next_i = start_i + dy[k];
                int next_j = start_j + dx[k];

                if (count_dis[next_i][next_j] == -1) {
                    queue_N.offer(new Point(next_i, next_j));
                    count_dis[next_i][next_j] = count_dis[start_i][start_j] + 1;

                    land[next_i][next_j] = land[start_i][start_j];
                }
            }
        }


        int min_dis = 0;
        for (int i = 1; i <= num_N; i++) {
            for (int j = 1; j <= num_N; j++) {
                for (int k = 0; k < 4; k++) {
                    int next_i = i + dy[k];
                    int next_j = j + dx[k];

                    if(1 <= next_i && next_i <=num_N && 1 <= next_j && next_j <= num_N) {
                        if (land[i][j] != land[next_i][next_j]) {
                            int sum = count_dis[i][j] + count_dis[next_i][next_j];
                            if (min_dis == 0) min_dis = sum;
                            if (min_dis > sum) min_dis = sum;
                        }
                    }
                }
            }
        }
        System.out.println(min_dis);
    }

    public static class Point {
        int X, Y;

        public Point(int Y, int X) {
            this.Y = Y;
            this.X = X;
        }
    }
}
