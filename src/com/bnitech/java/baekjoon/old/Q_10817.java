package com.bnitech.java.baekjoon.old;

import java.util.Scanner;

public class Q_10817 {
	public static void main(String[] args) {
		new Q_10817().start();
	}

	public void start(){
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		for (int i = 0; i < 3; i++) {
			rank(i,sc.nextInt(),num); 
		}
		System.out.println(num[1]);
	}
	public void rank(int i, int su, int[] num){
		
		switch (i) {
		case 0:
			num[0] = su;
			break;
		case 1:
			if(num[0]>su){
				num[1] = num[0];
				num[0] = su;
			}else{
				num[1] = su;
			}
			break;
		case 2:
			if(num[0]>su){
				num[2] = num[1];
				num[1] = num[0];
				num[0] = su;
			}else{
				if(num[1]>su){
					num[2] = num[1];
					num[1] = su;
				}else{
					num[2] = su;
				}
			}
			break;
		}
	}
}
