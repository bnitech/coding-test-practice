package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_1149().start(br);
	}

	public void start(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numN = Integer.parseInt(st.nextToken());
		int[][] minCost = new int[numN][3];

		st = new StringTokenizer(br.readLine());

		for (int RGB = 0; RGB < 3; RGB++) {
			minCost[0][RGB] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < numN; i++) {
			findCost(minCost, new StringTokenizer(br.readLine()), i);
		}

		int min = minCost[numN - 1][0];
		for (int RGB = 1; RGB < 3; RGB++) {
			if (min > minCost[numN - 1][RGB])
				min = minCost[numN - 1][RGB];
		}

		System.out.println(min);

	}

	void findCost(int[][] minCost, StringTokenizer st, int crt) {

		for (int RGB = 0; RGB < 3; RGB++) {
			int preRGB = -1;
			if (RGB == 0) {
				if (minCost[crt - 1][1] <= minCost[crt - 1][2]) {
					preRGB = 1;
				} else {
					preRGB = 2;
				}
			} else if (RGB == 1) {
				if (minCost[crt - 1][2] <= minCost[crt - 1][0]) {
					preRGB = 2;
				} else {
					preRGB = 0;
				}
			} else if (RGB == 2) {
				if (minCost[crt - 1][0] <= minCost[crt - 1][1]) {
					preRGB = 0;
				} else {
					preRGB = 1;
				}
			}
			minCost[crt][RGB] += Integer.parseInt(st.nextToken()) + minCost[crt - 1][preRGB];
		}
	}
}
