package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1498 {

	public static void main(String[] args) {
		Q_1498 q_1498 = new Q_1498();
		q_1498.start();
	}
	
	
	public void start(){
		Scan sc = new Scan();
		
		String str = new String(sc.next());
		
		period(str);
		
	}
	
	void period(String str){
		
		int half = str.length()/2;
		
		String searchChars = new String();

		//Ž�� ����
		for (int i = 1 ; i < half+1; i++) {
			
			searchChars = new String(str.substring(0, i));
			
			int n=1 , nMax=0, len=0;
			
			int j =i;
			while(j <= str.length()-i) {
				if(searchChars.equals(str.substring(j,j+i))){
					n++;
					j += i;
				}else{
					n=0;
					j++;
				}
				
				if(nMax < n){
					nMax = n;
					len = n*i;
				}
			}
			if(nMax > 1)
				System.out.println(len+" "+nMax);
			
		}
	}
}

class Scan {
	BufferedReader br;
	StringTokenizer st;

	public Scan() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}

