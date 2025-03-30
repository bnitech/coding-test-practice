package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1463 {
	public int[] minCompute;
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int MAX_VALUE;

	public static void main(String[] args) throws Exception {
		new Q_1463().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());

		minCompute = new int[numN + 1];

		countCompute(1, numN);

		System.out.println(minCompute[numN]);
	}

	void countCompute(int st, int end) {

		MAX_VALUE = Integer.MAX_VALUE;
		for (int num = st; num <= end; num++) {
			int min = MAX_VALUE;
			int ch1 = MAX_VALUE, ch2 = MAX_VALUE, ch3 = MAX_VALUE;

			if (num == 1 || num == 2 || num == 3) {
				minCompute[num] = 1;
				continue;
			}

			if (num % 3 == 0) {
				ch3 = 1;
				ch3 += minCompute[num / 3];
				min = ch3;
			}

			if (num % 2 == 0) {
				ch2 = 1;
				ch2 += minCompute[num / 2];
				if (min > ch2)
					min = ch2;
			}

			ch1 = 1;
			ch1 += minCompute[num - 1];
			if (min > ch1)
				min = ch1;

			minCompute[num] = min;
		}

	}
}
