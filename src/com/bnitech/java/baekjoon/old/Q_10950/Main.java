package com.bnitech.java.baekjoon.old.Q_10950;

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
		int numT = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < numT; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
			
		}
	}
}
