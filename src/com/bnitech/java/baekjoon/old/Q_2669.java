package com.bnitech.java.baekjoon.old;

import java.util.Scanner;

public class Q_2669 {

	public static void main(String[] args) {
		Q_2669 q_2669 = new Q_2669();
		q_2669.start();
	}
	
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		boolean[][] matrix = new boolean[100][100];
		
		for (int i = 0; i < 4; i++) {
			int strX = sc.nextInt();
			int strY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			
			checkMatrix(matrix, strX, strY, endX, endY);
			
		}
		
		System.out.println(countM(matrix));
		
	}
	void checkMatrix(boolean[][] matrix, int strX, int strY, int endX, int endY){
		
		for (int i = strY; i < endY; i++) {
			for (int j = strX; j < endX; j++) {
				matrix[i][j]=true;
			}
		}

	}
	
	int countM(boolean[][] matrix){
		int count=0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j])
					count++;
			}
		}
		
		return count;
	}
}
