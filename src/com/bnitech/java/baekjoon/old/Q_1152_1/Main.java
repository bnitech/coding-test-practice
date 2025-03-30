package com.bnitech.java.baekjoon.old.Q_1152_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int count = 0;

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		System.out.println(st.countTokens());
	}

}
