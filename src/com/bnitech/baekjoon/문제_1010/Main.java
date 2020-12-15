package com.bnitech.baekjoon.문제_1010;

����_1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int[][] matrix;

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		int numT = Integer.parseInt(st.nextToken());

		matrix = new int[30][30];

		for (int i = 0; i < numT; i++) {
			st = new StringTokenizer(br.readLine());
			int numN = Integer.parseInt(st.nextToken());
			int numM = Integer.parseInt(st.nextToken());

			System.out.println(compute(numM, numN));
		}
	}

	public int compute(int n, int k) {
		if (n == k || k == 0)
			return 1;

		if (matrix[n][k] == 0) {
			matrix[n][k] = compute(n - 1, k) + compute(n - 1, k - 1);
		}

		return matrix[n][k];

	}
}
