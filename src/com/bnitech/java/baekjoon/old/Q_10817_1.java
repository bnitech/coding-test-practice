package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_10817_1 {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_10817_1().start(br);
	}
	
	public void start(BufferedReader br) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(Integer.parseInt(st.nextToken()));
		list.add(Integer.parseInt(st.nextToken()));
		list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list);

		System.out.println(list.get(1));
	}
}



