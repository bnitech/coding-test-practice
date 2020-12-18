package com.bnitech.baekjoon.Q_1065_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	
	public static void main(String[] args) throws Exception {
		new Main().start();
	}
	
	private void start() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numN = Integer.parseInt(st.nextToken());
		int[] num = new int[5];
		int count = 0;

		int size = 0;
		if (numN == 1000) {
			num[0] = 1;
			//num[1] = 0;
			//num[2] = 0;
			//num[3] = 0;
			size = 4;
		} else {
			if (numN < 1000 && numN >= 100) {
				num[size] = numN / 100;
				numN -= num[size++] * 100;
			}
			if (numN < 100 && numN >= 10) {
				num[size] = numN / 10;
				numN -= num[size++] * 10;
			}
			if (numN < 10 && numN >= 9) {
				num[size++] = numN;
			}
		}
		
		int idx =0;
		int preGap = 0;
		int gap = 0;
		while (idx == size) {
			if(idx ==0){
				preGap = num[idx+1] - num[idx];
			}else{
				gap = num[idx+1] - num[idx];
				if(preGap == gap){
					
				}else{
					idx=size;
				}
			}
			idx ++;
		}
	}
	void devide(){
		
	}
}
