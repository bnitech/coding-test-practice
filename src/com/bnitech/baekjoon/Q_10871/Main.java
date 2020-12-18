package com.bnitech.baekjoon.Q_10871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {

		st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numX = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		boolean start = true;
		for (int i = 1; i <= numN; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (numX > input) {
				if (start) {
					start = false;
				} else {
					System.out.print(" ");
				}
				System.out.print(input);
			}

		}
	}
}
