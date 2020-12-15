/*
그래프-플러드 필-미로 탐색
 */
package com.bnitech.acmicpc.Q_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num_N = Integer.parseInt(st.nextToken());
        int num_M = Integer.parseInt(st.nextToken());

        int[][] arr_N = new int[1 + num_N + 1][1 + num_M + 1];

        for (int i = 1; i <= num_N; i++) {
            String str_N = br.readLine();
            for (int j = 1; j <= num_M; j++) {
                arr_N[i][j] = (str_N.charAt(j - 1) - '0');
            }
        }

        int start_i = 1;
        int start_j = 1;

        Queue<Point> queue_N = new LinkedList<>();
        queue_N.offer(new Point(start_i, start_j,1));
        arr_N[start_i][start_j] = 0;

//      우, 하, 좌, 상
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        int min_count = num_N*num_M;

        while (queue_N.isEmpty() == false) {

            Point point = queue_N.poll();
            start_i = point.Y;
            start_j = point.X;

            if (start_i == num_N && start_j == num_M){
                if(min_count > point.deep){
                    min_count = point.deep;
                }

            }

//          우, 하, 좌, 상
            for (int i = 0; i < 4; i++) {
                if (arr_N[start_i + dy[i]][start_j + dx[i]] != 0) {
                    queue_N.offer(new Point(start_i + dy[i], start_j + dx[i],point.deep+1));
                    arr_N[start_i + dy[i]][start_j + dx[i]] = 0;
                }
            }
        }

        System.out.println(min_count);
    }

}

class Point {
    int X, Y;
    int deep;

    Point(int Y, int X, int deep) {
        this.Y = Y;
        this.X = X;
        this.deep = deep;
    }
}