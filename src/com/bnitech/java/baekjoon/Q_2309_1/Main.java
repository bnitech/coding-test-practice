package com.bnitech.java.baekjoon.Q_2309_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int[] nanjang = new int[10];

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			nanjang[i] = Integer.parseInt(st.nextToken());
			sum += nanjang[i];
		}
		check(sum);

		Arrays.sort(nanjang);

		for (int i = 1; i <= 9; i++) {
			if (nanjang[i] == 0)
				continue;

			System.out.println(nanjang[i]);
		}
	}

	public void check(int sum) {

		int front = 1, rear = 1;
		while (true) {

			rear++;
			if (rear > 9) {
				front++;
				rear = front + 1;
				if (front >= 9)
					break;
			}

			int gap = nanjang[front] + nanjang[rear];

			if (sum - gap == 100) {
				break;
			}

		}

		nanjang[front] = 0;
		nanjang[rear] = 0;

	}
}
