package com.bnitech.baekjoon.samsung.Q_13458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		System.out.println(main.solution());

	}

	public long solution() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numRoom = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sizeRoom = new int[numRoom];
		for (int i = 0; i < numRoom; i++) {
			sizeRoom[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int sizeMainDirector = Integer.parseInt(st.nextToken());
		int sizeSubDirector = Integer.parseInt(st.nextToken());

		long cntDirector = 0;

		for (int i = 0; i < numRoom; i++) {
			int size = sizeRoom[i];

			size -= sizeMainDirector;
			cntDirector++;
			if (size > 0) {
				if (size % sizeSubDirector == 0) {
					cntDirector += size / sizeSubDirector;
				} else {
					cntDirector += size / sizeSubDirector + 1;
				}
			}
		}
		return cntDirector;
	}
}
