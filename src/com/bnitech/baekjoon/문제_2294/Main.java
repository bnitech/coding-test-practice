package com.bnitech.baekjoon.문제_2294;

����_2294;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	
	int[] coins, count; 
	
	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {

		st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numK = Integer.parseInt(st.nextToken());
		
		
		coins = new int[numN];
		count = new int[numK+1];
		
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] =  Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coins);
		
		for (int i = 1; i <= numK; i++) {
			count[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= coins[0]; i++) {
			count[i] = 0;
		}
		
		for (int i = 0; i < numK; i++) {
			for (int j = 0; j < numN; j++) {
				if(i < coins[j]){
					break;
				}
				int tmp = count[i-coins[j]] + 1; 
				if(count[i+1] > tmp ){
					count[i+1] = tmp;
				}
			}
		}
		if(count[numN] == Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(count[numN]);
		}
	}

}
