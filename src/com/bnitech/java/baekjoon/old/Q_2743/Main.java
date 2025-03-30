package com.bnitech.java.baekjoon.old.Q_2743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main ( String[] args) throws IOException{
		new Main().start();
	}
	public void start() throws IOException{
		char[] inputs = br.readLine().toCharArray();
		
		System.out.println(inputs.length);
	}
}
