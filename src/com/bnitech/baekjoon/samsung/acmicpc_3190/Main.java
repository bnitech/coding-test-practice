package com.bnitech.baekjoon.samsung.acmicpc_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] atgs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_N = Integer.parseInt(br.readLine());
		int[][] arr_map = new int[1 + num_N + 1][1 + num_N + 1];
		for (int i = 0; i <= num_N; i++) {
			arr_map[0][i] = 1;
			arr_map[num_N+1][i] = 1;
			arr_map[i][0] = 1;
			arr_map[i][num_N+1] = 1;
		}

		int num_K = Integer.parseInt(br.readLine());
		for (int i = 0; i < num_K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			arr_map[Y][X] = 2;
		}

		int num_L = Integer.parseInt(br.readLine());
		Queue<L> queue_L = new LinkedList<>();

		for (int i = 0; i < num_L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char spin = st.nextToken().charAt(0);

			queue_L.offer(new L(time, spin));
		}
		queue_L.offer(new L(Integer.MAX_VALUE, 'S'));

		LinkedList<Point> link_move = new LinkedList<>();
		link_move.add(new Point(1, 1, 1));

		// ºÏ µ¿ ³² ¼­
		// ÁÂ »ó ¿ì
		int[][] dx = { { -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1 }, { 0, -1, 0 } };
		int[][] dy = { { 0, -1, 0 }, { -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1 } };
		// L D
		int[][] re_dir = { { 3, 1 }, { 0, 2 }, { 1, 3 }, { 2, 0 } };

		int count_time = 0;
		while (queue_L.isEmpty() == false) {
			L poll_L = queue_L.poll(); 
			int time = poll_L.time;
			char cur_spin = poll_L.spin;
			int cur_time = time - count_time;
			if(cur_spin=='S') cur_time = time;
			

			Point peek_point = link_move.peekFirst();
			int cur_Y = peek_point.Y;
			int cur_X = peek_point.X;
			int cur_dir = peek_point.dir;

			while (cur_time-- > 0) {
//				System.out.println(cur_time + " : " + cur_Y + "," + cur_X + " ->" + cur_dir);
				int next_Y = cur_Y + dy[cur_dir][1];
				int next_X = cur_X + dx[cur_dir][1];

				// ¸öÅë
				for (Point point : link_move) {
					if (point.Y == next_Y && point.X == next_X) {
						System.out.println(count_time + 1);
						return;
					}
				}

				// º®
				if (arr_map[next_Y][next_X] == 1) {
					System.out.println(count_time + 1);
					return;
				} else {

					if (cur_time == 0) {
						if (cur_spin == 'L')
							cur_dir = re_dir[cur_dir][0];
						else if (cur_spin == 'D')
							cur_dir = re_dir[cur_dir][1];
					}
					
					link_move.addFirst(new Point(next_Y, next_X, cur_dir));
					count_time++;
					if (arr_map[next_Y][next_X] == 2) {
						arr_map[next_Y][next_X] = 0;
					} else {
						link_move.removeLast();
					}
					
					cur_Y = next_Y;
					cur_X = next_X;
				}

			}

		}
		System.out.println(count_time);
	}

	public static class L {
		int time;
		char spin;

		public L(int time, char spin) {
			this.time = time;
			this.spin = spin;
		}
	}

	public static class Point {
		int Y, X, dir;

		public Point(int Y, int X, int dir) {
			this.Y = Y;
			this.X = X;
			this.dir = dir;
		}
	}

}
