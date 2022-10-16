package com.bnitech.java.baekjoon.Q_2444_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int[] nanjang = new int[10];

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());

		int numN = Integer.parseInt(st.nextToken());
		int leftRight = numN;
		int mid = 1;
		for (int i = 0; i <= 2 * (numN - 1); i++) {
			for (int j = 1; j < leftRight; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= mid; j++) {
				System.out.print("*");
			}

			if (i < numN - 1) {
				mid += 2;
				leftRight--;
			} else {
				mid -= 2;
				leftRight++;
			}

			System.out.println();
		}
	}
}