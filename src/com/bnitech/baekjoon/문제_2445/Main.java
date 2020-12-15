package com.bnitech.baekjoon.문제_2445;

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
		//3
		//1    6 
		//12  56
		//123456
		for (int i = 1; i <= numN; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= (numN-i)*2; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < numN; i++) {
			for (int j = 1; j <= (numN-i); j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= i*2; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (numN-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
