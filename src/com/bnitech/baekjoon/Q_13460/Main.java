/*
삼성 SW 역량 테스트 기출 문제
째로탈출 2
 */

package com.bnitech.acmicpc.Q_13460;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] atgs) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num_N = Integer.parseInt(st.nextToken());
        int num_M = Integer.parseInt(st.nextToken());
        int[][] arr_NM = new int[num_N][num_M];

        Queue<Point> queue_R = new LinkedList<>();
        Queue<Point> queue_B = new LinkedList<>();

        for (int i = 0; i < num_N; i++) {
            String str_N = br.readLine();
            for (int j = 0; j < num_M; j++) {
                int input = -1;
                if (str_N.charAt(j) == '.') input = 0;
                else if (str_N.charAt(j) == 'R') {
                    input = 1;
                    queue_R.offer(new Point(i, j, 0,false));
                } else if (str_N.charAt(j) == 'B') {
                    input = 2;
                    queue_B.offer(new Point(i, j, 0,false));
                } else if (str_N.charAt(j) == 'O') input = 3;

                arr_NM[i][j] = input;
            }
        }
//      우, 하 , 좌 ,상
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] check_NM = new boolean[num_N][num_M];

        while (queue_R.isEmpty() == false) {
            Point poll_point = queue_R.poll();
            Point start_point = poll_point;

            check_NM[start_point.Y][start_point.X] = true;

            for (int i = 0; i < 4; i++) {
                if (arr_NM[start_point.Y + dy[i]][start_point.X + dx[i]] != -1) {
                    Point next_point = new Point(start_point.Y+dy[i],start_point.X+dx[i],start_point.len+1,false);
                    while (arr_NM[next_point.Y][next_point.X] != -1) {
                        if(arr_NM[next_point.Y][next_point.X]==0){
                            next_point.finish = true;
                            break;
                        }

                        check_NM[next_point.Y][next_point.X] = true;
                        next_point.Y+=dy[i];
                        next_point.X+=dx[i];
                    }
                    queue_R.offer(new Point(next_point.Y-dy[i],next_point.X-dx[i],next_point.len,next_point.finish));
                }

                if (arr_NM[poll_point.Y][poll_point.X] ==) ;
                if (arr_NM[poll_point.Y][poll_point.X] == -1) ;
            }
        }
    }

    public static class Point {
        int X, Y, len;
        boolean finish;

        public Point(int Y, int X, int len, boolean finish) {
            this.Y = Y;
            this.X = X;
            this.len = len;
            this.finish = finish;
        }
    }
}
