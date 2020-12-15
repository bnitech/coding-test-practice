package com.bnitech.baekjoon.문제_2660;

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

		int[][] matrix = new int[numN + 1][numN + 1];
		while (true) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == -1 || B == -1)
				break;

			matrix[A][B]=1;
			matrix[B][A]=1;

		}
		
		result(matrix, numN);

		int[] temp = new int[numN+1];
		
		for (int i = 1; i <= numN; i++) {
			int max = 0;
			for (int j = 1; j <= numN; j++) {
				if(max < matrix[i][j])
					max = matrix[i][j];
				
				temp[i] = max;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= numN; i++) {
			if(min>temp[i]){
				min = temp[i];
			}
		}
		
		int count = 0;
		for (int i = 1; i < temp.length; i++) {
			if(temp[i]==min){
				count++;
			}
			
		}
		System.out.println(min+" "+count);
		for (int i = 1; i < temp.length; i++) {
			if(temp[i]==min){
				System.out.print(i+" ");
			}
			
		}

	}

	public void result(int[][] matrix, int numN) {

		for (int k = 1; k <= numN; k++) {
			for (int i = 1; i <= numN; i++) {
				for (int j = 1; j <= numN; j++) {
					if (i == j || matrix[i][k] == 0 || matrix[k][j] == 0) {
						continue;
					}
					if (matrix[i][j] == 0 || matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
	}
}
