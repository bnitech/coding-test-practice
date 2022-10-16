package com.bnitech.java.baekjoon.Q_1037;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) throws Exception {
		new Main().start();
	}
	public void start() throws Exception{
		st = new StringTokenizer(br.readLine());
		int su = Integer.parseInt(st.nextToken());
		
		int[] A = new int[su];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < su; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int numN =0;
		if(su%2==0){
			numN = A[0] * A[su-1];
		}else if(su%2==1){
			int mid = su/2;
			numN = A[mid]*A[mid];
		}
		
		System.out.println(numN);
	}
}
