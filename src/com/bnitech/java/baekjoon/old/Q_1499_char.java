package com.bnitech.java.baekjoon.old;

import java.util.Scanner;

public class Q_1499_char {

	public static void main(String[] args) {
		Q_1499_char q_1498 = new Q_1499_char();
		q_1498.start();
	}
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		
		char S[] = sc.next().toCharArray();
		
		period(S);
		
	}
	
	void period(char S[]){
		
		int half = S.length/2;
		
		for (int i = 1 ; i < half+2; i++) {
		
			int front = 0 , rear = i-1;
			int n=1 , nMax=0, len=0;
			int st = i;
			
			
			while(st+(rear - front) < S.length) {
				boolean pass = true;
				for (int j = 0; j <= (rear - front); j++) {
					if(S[front+j]!=S[st+front+j]){
						pass = false;
						break;
					}
				}
				if(pass){
					n++;
					st+=i;
				}else{
					n=0;
					st++;
				}
				
				if(nMax < n){
					nMax = n;
					len = n*i;
				}
				
			}
			
			if(nMax > 1)
				System.out.println(len+" "+nMax);
			
		}
	}
}
