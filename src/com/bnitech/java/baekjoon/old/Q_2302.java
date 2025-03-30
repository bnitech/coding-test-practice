package com.bnitech.java.baekjoon.old;

import java.util.Scanner;

public class Q_2302 {
	public static int[] dp; 
	public static void main(String[] args) {
		Q_2302 q_2302 = new Q_2302();
		q_2302.start();
	}

	private void start() {

		Scanner sc = new Scanner(System.in);
		
		int numN = sc.nextInt();
		int numM = sc.nextInt();
		
		dp = new int[numN];
		
		int VIPSeats[] = new int[numM+2]; 
		int gaps[] = new int[VIPSeats.length-1];
		
		for (int i = 0; i < VIPSeats.length; i++) {
			if(i==VIPSeats.length-1){
				VIPSeats[i]=VIPSeats.length-1;
				break;
			}
			VIPSeats[i] = sc.nextInt();
		}
		
		for (int i = 0; i < gaps.length; i++) {
			gaps[i] = VIPSeats[i] - VIPSeats[i+1] - 1; 
		}
	
		fibo(2);
		System.out.println(fibo(2));
	}
		
	int fibo(int numN){
		dp[0]=0;
		dp[1]=1;
		
		for (int i = 2; i <= numN; i++) {
			dp[numN] =  dp[numN-1] + dp[numN-2];
		}
	
		return dp[numN]; 
		
	}
}
