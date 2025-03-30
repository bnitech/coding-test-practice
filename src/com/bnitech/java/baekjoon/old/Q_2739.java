package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2739 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		new Q_2739().start(br);
	}
	
	void start(BufferedReader br) throws Exception {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numN = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(numN+" * "+i+" = "+numN*i);
		}
	}
}
