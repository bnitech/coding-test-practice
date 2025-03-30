package com.bnitech.java.baekjoon.old.Q_2562_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	public static void main(String[] args) throws IOException {
		new Main().start();
	}

	public void start() throws IOException {
		
		int max = 0, idx = 0;
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(max < num){
				max = num;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
