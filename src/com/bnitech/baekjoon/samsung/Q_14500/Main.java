package com.bnitech.baekjoon.samsung.Q_14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int numN, numM, maxSum;
	// ©Л го аб ╩С
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[][] mapArr;

	public static void main(String[] args) throws Exception {
		Main ex = new Main();
		System.out.println(ex.solution());
	}

	public int solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		numN = Integer.parseInt(st.nextToken());
		numM = Integer.parseInt(st.nextToken());

		mapArr = new int[numN][numM];
		
		maxSum = 0;
		
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < numM; j++) {
				mapArr[i][j] = Integer.parseInt(st.nextToken());
				boolean[][] checkedPoint = new boolean[numN][numM];
				checkedPoint[i][j] = true;

				searchBlock_dfs(new Point(j, i), 1, mapArr[i][j], checkedPoint);
				searchBlock_other(new Point(j, i), mapArr[i][j]);

			}
		}

		return maxSum;
	}

	public void searchBlock_dfs(Point point, int deep, int sum, boolean[][] checkedPoint) {

		if (deep == 4) {
			if (maxSum < sum) {
				maxSum = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = point.X + dx[i];
			int nextY = point.Y + dy[i];
			if (nextY >= 0 && nextY < numN && nextX >= 0 && nextX < numM) {
				if (checkedPoint[nextY][nextX] == false) {
					checkedPoint[nextY][nextX] = true;
					searchBlock_dfs(new Point(nextX, nextY), deep + 1, sum + mapArr[nextY][nextX], checkedPoint);
					checkedPoint[nextY][nextX] = false;
				}
			}

		}
	}

	public void searchBlock_other(Point point, int sum) {
		int cntBlock = 1;
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			int nextX = point.X + dx[i];
			int nextY = point.Y + dy[i];
			if (nextY >= 0 && nextY < numN && nextX >= 0 && nextX < numM) {
				cntBlock++;
				sum += mapArr[nextY][nextX];
				if(minCost > mapArr[nextY][nextX]) {
					minCost = mapArr[nextY][nextX];
				}
			}
		}
		if(cntBlock <4) {
			return;
		}else if(cntBlock > 4) {
			sum -= minCost;
		}else {
			if(maxSum < sum) {
				maxSum = sum;
			}
		}
	}

	public class Point {
		public int X, Y;

		public Point(int X, int Y) {
			this.X = X;
			this.Y = Y;
		}
	}
}
