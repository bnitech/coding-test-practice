package com.bnitech.java.baekjoon.Q_2010;

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
		int sum = -(numN -1);
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			sum += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sum);
	
	}
}
