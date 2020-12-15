package Q_13460;

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

		PointRB cur_R = null, cur_B = null;

		char[][] arr_map = new char[num_N][num_M];
		for (int i = 0; i < num_N; i++) {
			String str_map = br.readLine();
			for (int j = 0; j < num_M; j++) {
				arr_map[i][j] = str_map.charAt(j);
				if (str_map.charAt(j) == 'R') {
					cur_R = new PointRB(i, j, 0);
					arr_map[i][j] = '.';
				} else if (str_map.charAt(j) == 'B') {
					cur_B = new PointRB(i, j, 0);
					arr_map[i][j] = '.';
				}
			}
		}

		Queue<PointRB> queue_R = new LinkedList<>();
		Queue<PointRB> queue_B = new LinkedList<>();

		boolean[][] check_R = new boolean[num_N][num_M];

		// 우 하 좌 상
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		queue_R.offer(cur_R);
		queue_B.offer(cur_B);

		int min_time = Integer.MAX_VALUE;

		while (queue_R.isEmpty() == false) {
			cur_R = queue_R.poll();
			cur_B = queue_B.poll();

			for (int i = 0; i < 4; i++) {
				// 이동
				int next_R_X = cur_R.X + dx[i];
				int next_R_Y = cur_R.Y + dy[i];
				while (arr_map[next_R_Y][next_R_X] == '.') {
					next_R_X += dx[i];
					next_R_Y += dy[i];
				}

				int next_B_X = cur_B.X + dx[i];
				int next_B_Y = cur_B.Y + dy[i];
				while (arr_map[next_B_Y][next_B_X] == '.') {
					next_B_X += dx[i];
					next_B_Y += dy[i];
				}

				// 구멍
				if (arr_map[next_B_Y][next_B_X] == 'O') {
					continue;
				}

				if (arr_map[next_R_Y][next_R_X] == 'O') {
					System.out.println(cur_R.time + 1);
					return;
				}

				// 위치 조정
				if (next_R_X == next_B_X && next_R_Y == next_B_Y) {
					// 우 = 0,1
					if (i == 0) {
						if (cur_R.X < cur_B.X) {
							next_R_X -= dx[i];
						} else {
							next_B_X -= dx[i];
						}
					}

					// 하 = 1,0
					else if (i == 1) {
						if (cur_R.Y < cur_B.Y) {
							next_R_Y -= dy[i];
						} else {
							next_B_Y -= dy[i];
						}
					}
					// 좌 = 0,-1
					else if (i == 2) {
						if (cur_R.X < cur_B.X) {
							next_B_X -= dx[i];
						} else {
							next_R_X -= dx[i];
						}
					}
					// 상 = -1,0
					else {
						if (cur_R.Y < cur_B.Y) {
							next_B_Y -= dy[i];
						} else {
							next_R_Y -= dy[i];
						}
					}
				}

				if (cur_R.time < 9) {
					queue_R.offer(new PointRB(next_R_Y - dy[i], next_R_X - dx[i], cur_R.time + 1));
					queue_B.offer(new PointRB(next_B_Y - dy[i], next_B_X - dx[i], cur_R.time + 1));

//					System.out.println("===" + cur_R.time + "==" + i + "===");
//					char[][] print_map = arr_map.clone();
//					print_map[next_R_Y - dy[i]][next_R_X - dx[i]] = 'R';
//					print_map[next_B_Y - dy[i]][next_B_X - dx[i]] = 'B';
//
//					for (int j = 0; j < num_N; j++) {
//						for (int j2 = 0; j2 < num_M; j2++) {
//							System.out.print(print_map[j][j2]);
//						}
//						System.out.println();
//					}
//
//					print_map[next_R_Y - dy[i]][next_R_X - dx[i]] = '.';
//					print_map[next_B_Y - dy[i]][next_B_X - dx[i]] = '.';
				}

			}

		}
		System.out.println(-1);
	}

	public static class PointRB {
		int X, Y, time;

		public PointRB(int Y, int X, int time) {
			this.Y = Y;
			this.X = X;
			this.time = time;
		}
	}
}
