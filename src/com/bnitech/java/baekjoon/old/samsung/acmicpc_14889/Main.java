package com.bnitech.java.baekjoon.old.samsung.acmicpc_14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int num_N;
	public static int[][] arr_N;
	public static int min_gap = Integer.MAX_VALUE;
	public static boolean[] check_N;

	public static void main(String[] atgs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num_N = Integer.parseInt(br.readLine());

		arr_N = new int[num_N+1][num_N+1];
		for (int i = 1; i <= num_N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= num_N; j++) {
				arr_N[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check_N = new boolean[num_N+1];

		dfs(0, 0);
		System.out.println(min_gap);
	}

	public static void dfs(int V, int deep) {
		if (deep == num_N / 2) {
			divTeam();
		} else {
			for (int i = V + 1; i <= num_N; i++) {
				if (check_N[i] == false) {
					check_N[i] = true;
					dfs(i, deep + 1);
				}
			}

		}
		check_N[V] = false;
	}

	public static void divTeam() {
		ArrayList<Integer> team_A = new ArrayList<>();
		ArrayList<Integer> team_B = new ArrayList<>();
		
		for (int i = 1; i <= num_N; i++) {
			if(check_N[i]) {
				team_A.add(i);
			}else {
				team_B.add(i);
			}
		}
		
		
		int score_A = teamScore(team_A);
		int score_B = teamScore(team_B);
		int gap = Math.abs(score_A-score_B);
		
		if(min_gap > gap) min_gap = gap;
	}
	public static int teamScore(ArrayList<Integer> team) {
		int sum =0;
		for (int i = 0; i < num_N/2; i++) {
			for (int j = 0; j < num_N/2; j++) {
				sum += arr_N[team.get(i)][team.get(j)];
			}
		}
		return sum;
	}
}
