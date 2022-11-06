package com.bnitech.java.baekjoon.Q_1260_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public StringTokenizer st = new StringTokenizer("");
	public Stack<Integer> stack = new Stack<Integer>();
	public Queue<Integer> queue = new LinkedList<Integer>();
	public LinkedList<LinkedList<Integer>> graph = new LinkedList<LinkedList<Integer>>();

	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	private void start() throws Exception {
		st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numM = Integer.parseInt(st.nextToken());
		int stV = Integer.parseInt(st.nextToken());

		for (int i = 0; i < numN + 1; i++) {
			graph.add(new LinkedList<Integer>());
		}

		for (int i = 0; i < numM; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeL = Integer.parseInt(st.nextToken());
			int nodeR = Integer.parseInt(st.nextToken());

			graph.get(nodeL).add(nodeR);
			graph.get(nodeR).add(nodeL);
		}

		int[] output = DFS(numN, stV);
		for (int i = 0; i < numN; i++) {
			System.out.print(output[i] + " ");
		}

		System.out.println();

		output = BFS(numN, stV);
		for (int i = 0; i < numN; i++) {
			System.out.print(output[i]);
			if (i != numN - 1)
				System.out.print(" ");
		}
	}

	public int[] DFS(int numN, int stV) {
		boolean[] check = new boolean[numN + 1];
		int[] output = new int[numN];
		int OPIdx = 0;
		while (OPIdx < numN) {

			if (check[stV]) {

				boolean find = false;
				Collections.sort(graph.get(stV));
				for (int i = 0; i < graph.get(stV).size(); i++) {
					int node = graph.get(stV).get(i);
					if (check[node]) {
					} else {
						stV = node;
						find = true;
						break;
					}
				}
				if (!find) {
					stack.pop();
					stV = stack.peek();
				}

			} else {
				stack.push(stV);
				output[OPIdx] = stV;
				check[stV] = true;
				OPIdx++;
			}

		}
		return output;
	}

	public int[] BFS(int numN, int stV) {
		boolean[] check = new boolean[numN + 1];
		int[] output = new int[numN];
		int OPIdx = 0;

		output[OPIdx] = stV;
		check[stV] = true;
		OPIdx++;
		while (OPIdx < numN) {

			Collections.sort(graph.get(stV));
			for (int i = 0; i < graph.get(stV).size(); i++) {
				int node = graph.get(stV).get(i);
				if (check[node]) {
				} else {
					queue.offer(node);
					check[node] = true;
				}
			}

			stV = queue.poll();
			output[OPIdx] = stV;
			OPIdx++;

		}
		return output;
	}
}
