package com.bnitech.java.baekjoon.old;

public class Q_2231 {

	public static void main(String[] args) {
		Q_2231 q_2231 = new Q_2231();
		q_2231.start();
	}
	
	
	public void start(){
		Scan sc = new Scan();
		
		String chars = sc.next();
		int len = chars.length();
		int num = Integer.parseInt(chars);
		int[] numbers = new int[len];
		
		for (int i = 0; i < len; i++) {
			numbers[i] = Character.getNumericValue(chars.charAt(i));
		}
		
		bun(numbers, len, num);
	}
	
	void bun(int[] numbers, int len, int num){
		for (int i = 0; i < len; i++) {
			double multi = Math.pow(10, i);
			
		}
	}
}
