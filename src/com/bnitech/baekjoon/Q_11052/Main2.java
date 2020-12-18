package com.bnitech.baekjoon.Q_11052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception {
//		Main main = new Main();
//		System.out.println(main.solution());

	}

	public int solution() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numN = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] memoN = new int[numN + 1];
		int[] costArr = new int[numN + 1];
		for (int i = 1; i <= numN; i++) {
			costArr[i] = Integer.parseInt(st.nextToken());
		}
		memoN[1] = costArr[1];
		for (int i = 2; i <= numN; i++) {
			for (int j = 1; j <= i; j++) {
				if (memoN[i] < memoN[i - j] + costArr[j]) {
					memoN[i] = memoN[i - j] + costArr[j];
				}
			}
		}

		return memoN[numN];
	}
}
