package com.bnitech.java.baekjoon.Q_2577_1;

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
		
		long intNum = 1;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int numN = Integer.parseInt(st.nextToken());
			
			intNum *= numN;
		}
		
		String stNum = String.valueOf(intNum);
		
		char[] charNum = stNum.toCharArray();
		
		int[] numCount = new int[10];
		
		for (int i = 0; i < charNum.length; i++) {
			int su = charNum[i] - '0'; 
			numCount[su]++;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(numCount[i]);
		}
		
	}
}
