package com.bnitech.baekjoon.문제_2558;

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
		int A = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A += Integer.parseInt(st.nextToken());
		
		System.out.println(A);
	}		
}
