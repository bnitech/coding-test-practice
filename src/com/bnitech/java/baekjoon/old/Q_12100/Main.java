package Q_12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num_N = Integer.parseInt(br.readLine());

		int[][] origin_map = new int[1 + num_N + 1][1 + num_N + 1];

		for (int i = 1; i <= num_N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= num_N; j++) {
				origin_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i <= num_N + 1; i++) {
			origin_map[0][i] = -1;
			origin_map[num_N + 1][i] = -1;
			origin_map[i][0] = -1;
			origin_map[i][num_N + 1] = -1;
		}


	
		Queue<Maps> queue_map = new LinkedList<>();
		queue_map.offer(new Maps(origin_map, 0));

		int max_su = 0;
		while (queue_map.isEmpty() == false) {
			Maps poll_map = queue_map.poll();

			// print(poll_map.arr_map,num_N,"=="+poll_map.count+"==");

			if (poll_map.count <= 5) {
				for (int i = 1; i <= num_N; i++) {
					for (int j = 1; j <= num_N; j++) {
						if (max_su < poll_map.arr_map[i][j])
							max_su = poll_map.arr_map[i][j];
					}
				}
				if(poll_map.count == 5) continue;
			}
			

			
			for (int i = 0; i < 4; i++) {
				Maps tmp_map = moveMap(poll_map, num_N, i);
				queue_map.offer(tmp_map);
			}

		}

		System.out.println(max_su);
	}

	public static Maps moveMap(Maps map, int n, int dir) {
		if (dir == 0) {
			for (int i = 1; i <= n; i++) {
				Queue<Integer> queue_su = new LinkedList<>();
				for (int j = n; j >= 1; j--) {
					int rear_su = 0;
					if (map.arr_map[i][j] != 0) {
						rear_su = map.arr_map[i][j];

						int front_idx = j;
						while (--front_idx > 0) {
							if (map.arr_map[i][front_idx] != 0) {
								if (map.arr_map[i][front_idx] == rear_su) {
									rear_su *= 2;
									map.arr_map[i][front_idx] = 0;
								}
								break;
							}
						
						}
						queue_su.offer(rear_su);
					}
				}
				for (int j = n; j >= 1; j--) {
					if (queue_su.isEmpty() == false) {
						map.arr_map[i][j] = queue_su.poll();
					} else {
						map.arr_map[i][j] = 0;
					}
				}
				
			}
		} else if (dir == 1) {
			for (int i = 1; i <= n; i++) {
				Queue<Integer> queue_su = new LinkedList<>();
				for (int j = n; j >= 1; j--) {
					int rear_su = 0;
					if (map.arr_map[j][i] != 0) {
						rear_su = map.arr_map[j][i];

						int front_idx = j;
						while (--front_idx > 0) {
							if (map.arr_map[front_idx][i] != 0) {
								if (map.arr_map[front_idx][i] == rear_su) {
									rear_su *= 2;
									map.arr_map[front_idx][i] = 0;
								}
								break;
							}
						
						}
						queue_su.offer(rear_su);
					}
				}
				for (int j = n; j >= 1; j--) {
					if (queue_su.isEmpty() == false) {
						map.arr_map[j][i] = queue_su.poll();
					} else {
						map.arr_map[j][i] = 0;
					}
				}
			}
		} else if (dir == 2) {
			for (int i = 1; i <= n; i++) {
				Queue<Integer> queue_su = new LinkedList<>();
				for (int j = 1; j <= n; j++) {
					int rear_su = 0;
					if (map.arr_map[i][j] != 0) {
						rear_su = map.arr_map[i][j];

						int front_idx = j;
						while (++front_idx <= n) {
							if (map.arr_map[i][front_idx] != 0) {
								if (map.arr_map[i][front_idx] == rear_su) {
									rear_su *= 2;
									map.arr_map[i][front_idx] = 0;
								}
								break;
							}
						
						}
						queue_su.offer(rear_su);
					}
				}
				for (int j = 1; j <= n; j++) {
					if (queue_su.isEmpty() == false) {
						map.arr_map[i][j] = queue_su.poll();
					} else {
						map.arr_map[i][j] = 0;
					}
				}
			}
		} else if (dir == 3) {
			for (int i = 1; i <= n; i++) {
				Queue<Integer> queue_su = new LinkedList<>();
				for (int j = 1; j <= n; j++) {
					int rear_su = 0;
					if (map.arr_map[j][i] != 0) {
						rear_su = map.arr_map[j][i];

						int front_idx = j;
						while (++front_idx <=n) {
							if (map.arr_map[front_idx][i] != 0) {
								if (map.arr_map[front_idx][i] == rear_su) {
									rear_su *= 2;
									map.arr_map[front_idx][i] = 0;
								}
								break;
							}
						
						}
						queue_su.offer(rear_su);
					}
				}

				for (int j = 1; j <= n; j++) {
					if (queue_su.isEmpty() == false) {
						map.arr_map[j][i] = queue_su.poll();
					} else {
						map.arr_map[j][i] = 0;
					}
				}
			}
		}


		return new Maps(map.arr_map, map.count+1);
	}

	public static void print(int[][] map, int n, String output) {

		System.out.println(output);

		for (int k = 1; k <= n; k++) {
			for (int l = 1; l <= n; l++) {
				System.out.print(map[k][l] + " ");
			}
			System.out.println();
		}
	}

	public static class Maps {
		int[][] arr_map;
		int count;

		public Maps(int[][] map, int count) {
			this.arr_map = map;
			this.count = count;
		}
	}
}
