package com.bnitech.java.baekjoon.old.samsung.Q_14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main ex = new Main();

		System.out.println(ex.solution());
	}

	public int solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numN = Integer.parseInt(br.readLine());
		int[] numT = new int[numN + 1];
		int[] numP = new int[numN + 1];
		StringTokenizer st = new StringTokenizer("");
		for (int i = 1; i <= numN; i++) {
			st = new StringTokenizer(br.readLine());
			numT[i] = Integer.parseInt(st.nextToken());
			numP[i] = Integer.parseInt(st.nextToken());
		}
		int[] memoArr = new int[numN + 2];

		for (int i = numN; i >= 0; i--) { 
			if ((i-1) + numT[i] <= numN) {
				memoArr[i] = Math.max(numP[i] + memoArr[i + numT[i]], memoArr[i + 1]);
			}else {
				memoArr[i] = memoArr[i+1];
			}
		}

		return memoArr[1];
	}
}
