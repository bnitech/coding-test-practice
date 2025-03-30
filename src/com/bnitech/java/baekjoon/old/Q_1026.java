package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_1026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_1026().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st;
		int numN = Integer.parseInt(br.readLine());

		ArrayList<Integer> alA = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numN; i++) {
			alA.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(alA);

		ArrayList<Integer> alB = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numN; i++) {
			alB.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(alB);

		Collections.reverse(alA);

		long sum = 0;
		for (int i = 0; i < numN; i++) {
			sum += alA.get(i) * alB.get(i);
		}

		System.out.println(sum);
	}
}
