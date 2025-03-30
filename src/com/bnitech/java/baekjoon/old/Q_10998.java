package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_10998 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		new Q_10998().start(br);
	}
	
	void start(BufferedReader br) throws Exception {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());
		
		System.out.println(numA*numB);
	}
}
