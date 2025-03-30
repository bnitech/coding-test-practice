package com.bnitech.java.baekjoon.old;

public class Q1 {

	public static int S[] = {5,7,8,10,11,13}; 
	public static void main(String[] args) {
		
		int x = 11;
		
		//if(Sol1(S,x)) System.out.println("Yes");
		//else System.out.println("No");
		
		if(Sol2(S,x,0,S.length-1)) System.out.println("Yes");
		else System.out.println("No");
	}
	
	static boolean Sol1(int S[], int x){
		boolean Yes = false;
		for (int i = 0; i < S.length; i++) {
			if(S[i]==x){
				Yes = true;
				break;
			}
		}
		 
		if(Yes) return true; 
		else return false;
	}
	
	static boolean Sol2(int S[], int x, int front, int rear){
		
		boolean Yes = false;
		 
		int node = rear-front;

		if(node<2){ 
			for (int i = front; i <= rear; i++) {
				if(S[i]==x){
					return true;
				}
			}
			return false;
		}
		
		int half = front + node/2;
		
		if(S[half] < x){
			Yes = Sol2(S,x,half+1,rear);
		}else if(S[half] > x){
			Yes = Sol2(S,x,front,half-1);
		}else{
			Yes = true;
		}
		
		
		if(Yes) return true;
		else return false;
	}		
}
