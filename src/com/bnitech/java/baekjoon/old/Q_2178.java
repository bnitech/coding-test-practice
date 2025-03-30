package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_2178 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_2178().strat(br);
	}

	private void strat(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numM = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[numN + 2][numM + 2];
		for (int i = 1; i <= numN + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= numM; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Stack<Integer> dfs = new Stack<Integer>();

		int[] dir = new int[4]; // 0 , 1, 2, 3 �����¿�
		int total = 0;
		int count = 0;
		int row = 1;
		int col = 1;
		int[] tmpLoc = {col,row};
		
		while (true) {
			count++;
			
			if(dfs.isEmpty()){
				col = tmpLoc[0];
				row = tmpLoc[1];
				count=0;
				
				// �� : 0
				if (matrix[col - 1][row] == 1) {
					dfs.push(0);
				}
				// �� : 1
				if (matrix[col + 1][row] == 1) {
					dfs.push(1);
				}
				// �� : 2
				if (matrix[col][row - 1] == 1) {
					dfs.push(2);
				}
				// �� : 3
				if (matrix[col][row + 1] == 1) {
					dfs.push(3);
				}
				
			}else{
				if(dfs.size()==1){
					total += count;
					count=0;
				}
				
				tmpLoc[0] = col;
				tmpLoc[1] = row;
				
				switch (dfs.pop()) {
				case 0:
					row--;
					break;
				case 1:
					row++;
					break;
				case 2:
					col--;
					break;
				case 3:
					col++;
					break;
				default:
					break;
				}
			}
			
			
		}

	}

}
