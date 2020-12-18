package com.bnitech.baekjoon.Q_2178_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int i;
	int j;
	int step;

	Node(int i, int j, int step) {
		this.i = i;
		this.j = j;
		this.step = step;
	}
}

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public Queue<Node> queue = new LinkedList<Node>();

	public int[] dirRow = { 1, -1, 0, 0 };
	public int[] dirCol = { 0, 0, -1, 1 };
	public int[][] map;

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numM = Integer.parseInt(st.nextToken());
		map = new int[numN + 2][numM + 2];

		for (int i = 1; i <= numN; i++) {
			String s = br.readLine();
			for (int j = 1; j <= numM; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}

		queue.offer(new Node(1, 1, 1));

		while (!queue.isEmpty()) {
			Node nodes = queue.poll();
			int step = nodes.step;
			
			if (nodes.i == numN && nodes.j == numM) {
				
				System.out.println(nodes.step);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int row = nodes.i + dirRow[i];
				int col = nodes.j + dirCol[i];

				if (map[row][col] == 0) {
					continue;
				}else if(map[row][col] == 1){
					map[row][col] = 0;
					queue.offer(new Node(row,col,step+1));
				}
			}


		}

	}
}
