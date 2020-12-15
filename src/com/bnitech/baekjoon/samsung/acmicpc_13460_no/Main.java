/*
삼성 SW 역량 테스트 기출 문제
구슬 탈출 2
 */

package com.bnitech.baekjoon.samsung.acmicpc_13460_no;

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

		char[][] arr_NM = new char[num_N][num_M];

		Point point_R = new Point();
		Point point_B = new Point();
		for (int i = 0; i < num_N; i++) {
			String str_N = br.readLine();
			for (int j = 0; j < num_M; j++) {
				char input = str_N.charAt(j);
				if (input == 'R') {
					point_R = new Point(i, j,0);
				} else if (input == 'B') {
					point_B = new Point(i, j,0);
				}
				arr_NM[i][j] = input;
			}
		}

		// 우, 하 , 좌 ,상
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		boolean[][][][] check_NM = new boolean[num_N][num_M][num_N][num_M];

		Queue<Point> queue_R = new LinkedList<>();
		Queue<Point> queue_B = new LinkedList<>();
		queue_R.add(point_R);
		queue_B.add(point_B);

		check_NM[point_R.Y][point_R.X][point_B.Y][point_B.X] = true;

		int min_move = num_N * num_N;

		while (queue_R.isEmpty() == false) {
			Point poll_R = queue_R.poll();
			Point poll_B = queue_B.poll();
			
			System.out.println(poll_R.Y+","+poll_R.X+" : "+poll_R.move);

			for (int i = 0; i < 4; i++) {

				int R_Y = poll_R.Y, R_X = poll_R.X;
				int B_Y = poll_B.Y, B_X = poll_B.X;
				int R_step = 0, B_step = 0;

				while (arr_NM[R_Y + dy[i]][R_X + dx[i]] != '#' && arr_NM[R_Y][R_X] != 'O') {
					R_Y += dy[i];
					R_X += dx[i];
					R_step++;
				}
				while (arr_NM[B_Y + dy[i]][B_X + dx[i]] != '#' && arr_NM[B_Y][B_X] != 'O') {
					B_Y += dy[i];
					B_X += dx[i];
					B_step++;
				}

				if (R_Y == B_Y && R_X == B_X) {
					if (R_step > B_step) {
						R_Y -= dy[i];
						R_X -= dx[i];
					} else if (R_step < B_step) {
						B_Y -= dy[i];
						B_X -= dx[i];
					} else {
						System.out.println("ERROR - 1");
					}
				}
				
				if(arr_NM[B_Y][B_X]=='O') continue;
				if(arr_NM[R_Y][R_X]=='O') {
					if(min_move > poll_R.move) min_move = poll_R.move+1;
					continue;
				}

				if (check_NM[R_Y][R_X][B_Y][B_X] == true)
					continue;

				if (poll_R.move < 10) {
					check_NM[R_Y][R_X][B_Y][B_X] = true;
					System.out.println("add => "+R_Y+","+R_X+" : " + (poll_R.move+1));
					queue_R.add(new Point(R_Y,R_X,poll_R.move+1));
					queue_B.add(new Point(B_Y,B_X,poll_B.move+1));
				}

			}
		}
		if(min_move<num_N*num_M) {
			System.out.println(min_move);
		}
		else System.out.println(-1);
	}

	public static class Point {
		int Y, X, move;

		public Point(int Y, int X, int move) {
			this.Y = Y;
			this.X = X;
			this.move = move;
		}
		public Point() {
			
		}
	}
}
