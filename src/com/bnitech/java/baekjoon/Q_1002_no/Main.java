package com.bnitech.java.baekjoon.Q_1002_no;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		int numT = Integer.parseInt(st.nextToken());
		for (int i = 0; i < numT; i++) {
			st = new StringTokenizer(br.readLine());
			int aX = Integer.parseInt(st.nextToken());
			int aY = Integer.parseInt(st.nextToken());
			int aR = Integer.parseInt(st.nextToken());
			int bX = Integer.parseInt(st.nextToken());
			int bY = Integer.parseInt(st.nextToken());
			int bR = Integer.parseInt(st.nextToken());
			
			double d =Math.sqrt((bX-aX)*(bX-aX) + (bY-aY)*(bY-aY));
			
			if(d==0){
				if(aR==bR){
					System.out.println(-1);
				}else{
					System.out.println(0);
				}
			}else{
				if(d==aR+bR){
					System.out.println(1);
				}else if(d>aR+bR){
					System.out.println(0);
				}else{
					if(d==Math.abs(aR-bR)){
						System.out.println(1);
					}else if(d < Math.abs(aR-bR)){
						System.out.println(0);
					}else{
						System.out.println(2);
					}
				}
			}			
		}
	}

}
