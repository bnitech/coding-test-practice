package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_1629().start(br);
	}

	public void start(BufferedReader br) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());
		int numC = Integer.parseInt(st.nextToken());

		ArrayList<Long> restSu = new ArrayList<Long>();

		int rest = numA % numC;

		long su = rest;
		boolean pass = false;
		int total = 1;
		while (!pass) {
			restSu.add(su);

			su *= su;
			su = su % numC;

			for (Long temp : restSu) {
				if (temp == su) {
					total++;
					if(total>(numC)){
						pass = true;
						break;	
					}
				}
			}
		}

		int count = numB % restSu.size();

		long result = restSu.get(count);

		System.out.println(result);
	}
}
