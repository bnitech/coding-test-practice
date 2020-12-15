package com.bnitech.baekjoon.문제_1254;

����_1254;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public int count = 0;

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		char[] input = br.readLine().toCharArray();
		int len = input.length;
		boolean run = true;
		if(checkPal(input,len)){
			System.out.println(len+count);
			return;
		}
		while (run) {
			run = addChar(input, len);
		}
		System.out.println(len+count+1);
	}

	public boolean checkPal(char[] input, int len) {
		int end = len-1;
		for (int i = 0; i < len / 2; i++) {
			if (input[i] != input[end]) {
				return false;
			}
			end--;
		}
		return true;
	}

	public boolean addChar(char[] input, int len) {
		char[] temp = new char[len + count + 2];
		for (int i = 0; i < len; i++) {
			temp[i] = input[i]; 
		}
		int i = count;
		int gap = count;
		while (i > -1) {
			temp[len + gap-i] = input[i];
			i--;
			
		}
		if (checkPal(temp, len+count+1)) {
			return false;
		} else {
			count++;
		}
		return true;
		
	}
}
