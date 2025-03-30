package com.bnitech.java.baekjoon.old;

import java.util.Scanner;

public class Q_1520 {

	public static Dir[][] dp;
	public static void main(String[] args) {
		Q_1520 q_1520 = new Q_1520();
		q_1520.start();
	}
	public void start(){
		Scanner sc = new Scanner(System.in);
		int numN = sc.nextInt();
		int numM = sc.nextInt();
		
		int[][] arr = new int[numN+2][numM+2];
		dp = new Dir[numN+2][numM+2];
		
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				arr[j][i] = sc.nextInt();
			}
		}
		
		init(arr);
		checkYes();
		countWay();
		
	}
	private void init(int[][] arr) {
		
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				if(arr[j-1][i] > arr[j][i]){
					dp[j][i].dirs[0]=true;
					dp[j][i].Yes = true;
				}
				if(arr[j+1][i] > arr[j][i]){
					dp[j][i].dirs[1]=true;
					dp[j][i].Yes = true;
				}
				if(arr[j][i-1] > arr[j][i]){
					dp[j][i].dirs[2]=true;
					dp[j][i].Yes = true;
				}
				if(arr[j][i+1] > arr[j][i]){
					dp[j][i].dirs[3]=true;
					dp[j][i].Yes = true;
				}
			}
		}
		
		for (int i = 1; i < dp.length-1; i++) {
			for (int j = 1 ; j < dp.length-1; j++) {
				if(dp[j-1][i].Yes == false){
					dp[j][i].dirs[0]=false;
				}
				if(dp[j+1][i].Yes == false){
					dp[j][i].dirs[1]=false;
				}
				if(dp[j][i-1].Yes == false){
					dp[j][i].dirs[2]=false;
				}
				if(dp[j-1][i+1].Yes == false){
					dp[j][i].dirs[3]=false;
				}
			}
		}
		
	}
	private void checkYes(){
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				boolean check = false;
				for (int dir = 0; dir < 4; dir++) {
					if(dp[j][i].dirs[dir]){
						 check = true;
					}
				}
				if(!check) dp[j][i].Yes = false;
			}
		}
	}
	private void countWay(){
		for (int i = dp.length-2; i > 0 ; i--) {
			for (int j = dp.length-2; j > 0; j--) {
			}
		}
	}
}
class Dir {
	//�¿���� 0123
	boolean[] dirs = new boolean[4];
	boolean Yes = false;
}