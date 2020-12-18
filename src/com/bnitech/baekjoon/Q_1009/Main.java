package com.bnitech.baekjoon.Q_1009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int MAX_VALUE;

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		int Tcase = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Tcase; i++) {
			st = new StringTokenizer(br.readLine());
			int numA = Integer.parseInt(st.nextToken());
			int numB = Integer.parseInt(st.nextToken());

			System.out.println(compute(numA, numB));
		}
	}

	public int compute(int numA, int numB) {
		int data = 1;
		int pc = 0;
		for (int i = 1; i <= numB; i++) {
			data = data * numA;

			data = data % 10;

		}

		if (data == 0)
			pc = 10;
		else
			pc = data;

		return pc;
	}
}
