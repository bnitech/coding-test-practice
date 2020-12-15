package com.bnitech.baekjoon.samsung.Q_14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		System.out.println(main.solution());

	}

	public int numN, numM;
	public int maxCntSaveZone = 0;
	public int[][] mapArr;
	public List<Point> virusPointList;

	// public int cntPrint = 0;

	public int solution() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		numN = Integer.parseInt(st.nextToken());
		numM = Integer.parseInt(st.nextToken());

		mapArr = new int[numN][numM];
		virusPointList = new ArrayList<>();

		// map 세팅, 바이러스 시작지점 저장
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < numM; j++) {
				int num = Integer.parseInt(st.nextToken());
				mapArr[i][j] = num;

				if (num == 2) {
					virusPointList.add(new Point(j, i));
				}
			}
		}

		int[][] tmpMapArr = new int[numN][numM];

		for (int i = 0; i < numN; i++) {
			for (int j = 0; j < numM; j++) {
				if (mapArr[i][j] == 0) {

					for (int k = 0; k < numN; k++) {
						tmpMapArr[k] = mapArr[k].clone();
					}

					tmpMapArr[i][j] = 1;
					createWall_dfs(1, tmpMapArr);
					tmpMapArr[i][j] = 0;
				}
			}
		}

		int answer = maxCntSaveZone;
		return answer;
	}

	public void createWall_dfs(int cnt, int[][] tmpMapArr) {
		// 벽 3개
		if (cnt == 3) {
			virusSpread_bfs(tmpMapArr);
			// for (int i = 0; i < numN; i++) {
			// System.out.println(Arrays.toString(tmpMapArr[i]));
			// }
			// System.out.println("====================================================");
			return;
		}
		// 벽세우기
		for (int i = 0; i < numN; i++) {
			for (int j = 0; j < numM; j++) {
				if (tmpMapArr[i][j] == 0) {
					tmpMapArr[i][j] = 1;
					createWall_dfs(cnt + 1, tmpMapArr);

					// 탐색 완료
					tmpMapArr[i][j] = 0;
				}
			}
		}

	}

	public void virusSpread_bfs(int[][] tmpMapArr) {
		int[][] spreadMapArr = new int[numN][numM];
		for (int k = 0; k < numN; k++) {
			spreadMapArr[k] = tmpMapArr[k].clone();
		}

		Queue<Point> queuePoint = new LinkedList<>();

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 바이러스 시작지점 받기
		for (Point point : virusPointList) {
			queuePoint.offer(point);
		}

		while (queuePoint.isEmpty() == false) {
			Point curPoint = queuePoint.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = curPoint.X + dx[i];
				int nextY = curPoint.Y + dy[i];

				if (nextX >= 0 && nextX < numM & nextY >= 0 && nextY < numN) {
					if (spreadMapArr[nextY][nextX] == 1 || spreadMapArr[nextY][nextX] == 2) {
						continue;
					}
					queuePoint.offer(new Point(nextX, nextY));
					spreadMapArr[nextY][nextX] = 2;
				}
			}

		}
		int cntSaveZone = 0;
		for (int i = 0; i < numN; i++) {
			for (int j = 0; j < numM; j++) {
				if (spreadMapArr[i][j] == 0) {
					cntSaveZone++;
				}
			}
		}
		if (maxCntSaveZone < cntSaveZone) {
			maxCntSaveZone = cntSaveZone;
		}

	}

	public class Point {
		int X, Y;

		public Point(int X, int Y) {
			this.X = X;
			this.Y = Y;
		}
	}

}
