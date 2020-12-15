package com.bnitech.baekjoon.문제_2293;

����_2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) throws Exception {
		new Main().start();
	}
	public void start() throws Exception{
		st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numK = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[numN];
		
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coin);
		
		for (int i = 0; i < numN; i++) {
			if(numK%coin[i]==0){
				
			}else{
				
			}
		}
	}
}
