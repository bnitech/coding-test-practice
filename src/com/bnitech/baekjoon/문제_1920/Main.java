package com.bnitech.baekjoon.문제_1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
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
		int[] arrayN = new int[numN];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numN; i++) {
			arrayN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrayN);

		st = new StringTokenizer(br.readLine());
		int numM = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numM; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean check = false;
			check = searchNum(arrayN, 0, numN-1, num);
			if(check) System.out.println("1");
			else System.out.println("0");
		}

	}

	public boolean searchNum(int[] arrayN, int front, int rear, int num) {
		int mid = (front + rear) / 2;
		boolean check = false;
		
		
		
		if(rear-front <= 1){
			if(arrayN[front]==num) check = true;
			if(arrayN[rear]==num) check = true;
			return check;
		}
		
		
		if (arrayN[mid] == num)
			check = true;
		else if (arrayN[mid] > num) {
			check = searchNum(arrayN, front, mid-1, num);
		} else if (arrayN[mid] < num) {
			check = searchNum(arrayN, mid + 1, rear, num);
		}

		return check;
	}
}
