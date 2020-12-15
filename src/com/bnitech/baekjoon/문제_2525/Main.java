package com.bnitech.baekjoon.문제_2525;

����_2525;

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
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int cookTime = Integer.parseInt(st.nextToken());
		
		timeCheck(hour, minute, cookTime);
	}
	public void timeCheck(int hour, int minute, int cookTime){
		minute += cookTime;
		
		
		if(minute > 59){
			int count = minute/60;
			hour += count;
			minute %= 60;
		}
		if(hour > 23){
			hour %= 24;
		}
		
		System.out.println(hour+" "+minute);
	}
}
