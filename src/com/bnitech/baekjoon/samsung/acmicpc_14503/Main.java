package acmicpc_14503;

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

		st = new StringTokenizer(br.readLine());
		int cur_Y = Integer.parseInt(st.nextToken()) + 1;
		int cur_X = Integer.parseInt(st.nextToken()) + 1;
		int cur_dir = Integer.parseInt(st.nextToken());

		int[][] arr_map = new int[1 + num_N + 1][1 + num_M + 1];
		for (int i = 1; i <= num_N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= num_M; j++) {
				arr_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i <= num_M + 1; i++) {
			arr_map[0][i] = 1;
			arr_map[num_N + 1][i] = 1;
		}
		for (int i = 0; i <= num_N + 1; i++) {
			arr_map[i][0] = 1;
			arr_map[i][num_M + 1] = 1;
		}

		// 0 ºÏ, 1 µ¿, 2 ³², 3¼­
		// int[][] dx = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 }, { 1, 0, -1, 0 }, { 0, -1, 0,
		// 1 } };
		// int[][] dy = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 }, { 0, -1, 0, 1 }, { -1, 0, 1,
		// 0 } };
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int[] re_dir = { 3, 0, 1, 2 };
		int[] back_dx = { 0, -1, 0, 1 };
		int[] back_dy = { -1, 0, 1, 0 };

		int count_clean = 1;
		Queue<Point> queue_point = new LinkedList<>();
		queue_point.offer(new Point(cur_Y, cur_X, cur_dir));

		int[][] check_map = new int[1 + num_N + 1][1 + num_M + 1];

		int noClean = 0;
		while (queue_point.isEmpty() == false) {
			Point poll_point = queue_point.poll();
			cur_X = poll_point.X;
			cur_Y = poll_point.Y;
			cur_dir = poll_point.dir;

			if (arr_map[cur_Y][cur_X] == 0) {
				check_map[cur_Y][cur_X] = 1;
				noClean = 0;
				count_clean++;
			}

			if (noClean == 4) {
				
				int back_X = cur_X + back_dx[cur_dir];
				int back_Y = cur_Y + back_dy[cur_dir];

				if (arr_map[back_Y][back_Y] == 1) {
					break;
				} else {
					queue_point.offer(new Point(back_Y, back_X, cur_dir));
					noClean = 0;
				}
				break;
			}

			int next_X = cur_X + dx[cur_dir];
			int next_Y = cur_Y + dy[cur_dir];

			if (check_map[next_Y][next_X] == 1) {
				queue_point.offer(new Point(cur_Y, cur_X, re_dir[cur_dir]));
				noClean++;
				continue;
			}
			if (arr_map[next_Y][next_X] == 1) {
				queue_point.offer(new Point(cur_Y, cur_X, re_dir[cur_dir]));
				noClean++;
				continue;
			}
			queue_point.offer(new Point(next_Y, next_X, cur_dir));
		}
		System.out.println(count_clean);

	}

	public static class Point {
		int X, Y, dir;

		public Point(int Y, int X, int dir) {
			this.Y = Y;
			this.X = X;
			this.dir = dir;
		}
	}

}
