package com.bnitech.java.baekjoon.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_10825{
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_10825().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
	
		Grade[] grade = new Grade[numN];
		
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			grade[i] = new Grade(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(grade);
		
		
		for (Grade temp : grade) {
			System.out.print(temp.name+" ");
			//System.out.print(temp.kor+" ");
			//System.out.print(temp.eng+" ");
			//System.out.println(temp.math);
		}
			
	}
}

class Grade implements Comparable<Grade>{
	

	String name;
	int kor, eng, math;
	
	public Grade(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getKor(){
		return this.kor;
	}
	public void setKor(int kor){
		this.kor = kor;
	}
	public int getEng(){
		return this.eng;
	}
	public void setEng(int eng){
		this.eng = eng;
	}
	public int getMath(){
		return this.math;
	}
	public void setAge(int math){
		this.math = math;
	}

	@Override
	public int compareTo(Grade grade) {
		if(this.kor < grade.getKor()){
			return 1;
		}else if(this.kor > grade.getKor()){
			return -1;
		}else{
			if(this.eng < grade.getEng()){
				return -1;
			}else if(this.eng > grade.getEng()){
				return 1;
			}else{
				if(this.math < grade.getMath()){
					return 1;
				}else if(this.math > grade.getMath()){
					return -1;
				}else{
					return this.name.compareTo(grade.name);
				}
			}
		}
	}

	
}
