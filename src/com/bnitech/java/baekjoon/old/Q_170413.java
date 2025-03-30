package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_170413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_170413().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		
		/*
		 0 1 99 1 5
		 9 0 3 2 99
		 99 99 0 4 99
		 99 99 2 0 3
		 3 99 99 99 0 
		 */
		/*
		 0 1 99 99 99
		 5 0 3 10 99
		 1 99 0 4 99
		 99 99 5 0 2
		 2 99 99 7 0 
		 */
		
		int[][][] matrix = new int[numN+1][numN + 1][numN + 1];
		for (int i = 1; i <= numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= numN; j++){
				matrix[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] flowMatrix = new int[numN+1][numN+1][3];
		
		findFlow(numN ,matrix, flowMatrix);
		
		for (int k = 0; k <= numN; k++) {
			System.out.println("--"+ k +"--");
			for (int i = 1; i <= numN; i++) {
				for (int j = 1; j <= numN; j++) {
					System.out.print(matrix[k][i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();	
		}
		
		
		for (int i = 1; i <= numN; i++) {
			for (int j = 1; j <= numN; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.print(flowMatrix[i][j][k]);	
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		
		printFlow(flowMatrix, 4, 2);
	}

	void findFlow(int numN, int[][][] matrix, int[][][] flowMatrix) {
		for (int k = 1; k <= numN; k++) {
			for (int i = 1; i <= numN; i++) {
				for (int j = 1; j <= numN; j++) {
					int min1 = matrix[k-1][i][j];
					int min2 = matrix[k-1][i][k]+matrix[k-1][k][j];
					if(min1>min2){
						flowMatrix[i][j][0]=i;
						flowMatrix[i][j][1]=k;
						flowMatrix[i][j][2]=j;
						matrix[k][i][j] = min2;
					}else{
						flowMatrix[i][j][0]=i;
						flowMatrix[i][j][2]=j;
						matrix[k][i][j] = min1;
					}
				}
			}
		}
	}
	
	void printFlow(int[][][] flowMatrix, int i, int j) {
		if (flowMatrix[i][j][1] == 0) {
			System.out.print(flowMatrix[i][j][0]);
			System.out.print("->");
			System.out.print(flowMatrix[i][j][2]);
		} else {
			printFlow(flowMatrix, flowMatrix[i][j][0], flowMatrix[i][j][1]);
			System.out.println("");
			printFlow(flowMatrix, flowMatrix[i][j][1], flowMatrix[i][j][2]);
		}
		
	}
}
