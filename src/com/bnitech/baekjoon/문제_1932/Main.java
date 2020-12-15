package com.bnitech.baekjoon.문제_1932;

����_1932;

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
		int[][] sums = new int[numN+1][numN+1];

		for (int i = 1; i <= numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				sums[i][j] = Integer.parseInt(st.nextToken());
				if(sums[i-1][j-1] > sums[i-1][j]){
					sums[i][j] += sums[i-1][j-1];
				}else{
					sums[i][j] += sums[i-1][j];
				}
				
			}
			 
		}

		int max = 0;
		for (int i = 1; i <= numN; i++) {
			if (max < sums[numN][i]) {
				max = sums[numN][i];
			}
		}
		
		System.out.println(max);

	}

}
