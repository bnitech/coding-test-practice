package com.bnitech.java.baekjoon.old;

import java.util.LinkedList;
import java.util.Scanner;

public class Q_3190 {
	public static void main(String[] args) {
		Q_3190 q_3190 = new Q_3190();
		q_3190.start();
	}

	private void start() {

		Scanner sc = new Scanner(System.in);
		int numN = sc.nextInt();
		int numK = sc.nextInt();
		int[][] arr = new int[numN + 2][numN + 2];
		int[][] listApple = new int[2][numK + 1];

		if (numK == 0) {
			listApple[0][0] = 0;
			listApple[1][0] = 0;
		}

		for (int i = 0; i < listApple[0].length - 1; i++) {
			listApple[0][i] = sc.nextInt();
			listApple[1][i] = sc.nextInt();
		}

		int numL = sc.nextInt();
		int[][] listDir = new int[2][numL + 1];

		if (numK == 0) {
			listDir[0][0] = 0;
			listDir[1][0] = 0;
		}

		// Character.getNumericValue(c)
		// char b=(char)a
		for (int i = 0; i < listDir[0].length - 1; i++) {
			listDir[0][i] = sc.nextInt();
			listDir[1][i] = sc.next().charAt(0);
		}

		init(arr, listApple);

		int dir = 0;

		LinkedList<Integer[]> snakeBody = new LinkedList<Integer[]>();
		Integer[] body = new Integer[2];
		body[0] = 1;
		body[1] = 1;
		snakeBody.add(body);

		snakeMove(arr, snakeBody, listDir, dir);
	}

	void init(int[][] arr, int[][] listApple) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (i == 0 || j == 0) {
					arr[i][j] = -1;
				}
				if (i == arr.length - 1 || j == arr[0].length - 1) {
					arr[i][j] = -1;
				}

				for (int idx = 0; idx < listApple.length - 1; idx++) {
					if (i == listApple[0][idx] && j == listApple[1][idx]) {
						arr[i][j] = 1;
					}
				}
			}
		}
	}

	void snakeMove(int[][] arr, LinkedList<Integer[]> snakeBody, int[][] listDir, int dir) {

		boolean end = false;
		int time = 0;
		Integer[] body;
		
		while (!end) {
			body = new Integer[2];
			time++;
			System.out.println("�ð� : "+time);
			int idxDir = 0;
			if (time == listDir[0][idxDir]) {
				if ('D' == (char) listDir[1][idxDir]) {
					System.out.println("��ȸ��");
					if (dir == 0) {
						body[0] = snakeBody.peekLast()[0] + 1;
						body[1] = snakeBody.peekLast()[1];
						dir = 1;
					} else if (dir == 2) {
						body[0] = snakeBody.peekLast()[0] - 1;
						body[1] = snakeBody.peekLast()[1];
						dir = 3;
					} else if (dir == 1) {
						body[0] = snakeBody.peekLast()[0];
						body[1] = snakeBody.peekLast()[1] - 1;
						dir = 2;
					} else if (dir == 3) {
						body[0] = snakeBody.peekLast()[0];
						body[1] = snakeBody.peekLast()[1] + 1;
						dir = 0;
					} else {
						System.out.println("���� ��ȯ ���");
					}

				} else if ('L' == (char) listDir[1][idxDir]) {
					System.out.println("��ȸ��");
					if (dir == 0) {
						body[0] = snakeBody.peekLast()[0];
						body[1] = snakeBody.peekLast()[1] - 1;
						dir = 3;
					} else if (dir == 2) {
						body[0] = snakeBody.peekLast()[0] + 1;
						body[1] = snakeBody.peekLast()[1];
						dir = 1;
					} else if (dir == 1) {
						body[0] = snakeBody.peekLast()[0];
						body[1] = snakeBody.peekLast()[1] + 1;
						dir = 0;
					} else if (dir == 3) {
						body[0] = snakeBody.peekLast()[0];
						body[1] = snakeBody.peekLast()[1] - 1;
						dir = 2;
					} else {
						System.out.println("���� ��ȯ ���");
					}
				} else {
					System.out.println("���� �ν� ����");
				}

				idxDir++;

			} else {
				System.out.println("����");
				if (dir == 0) {
					body[0] = snakeBody.peekLast()[0];
					body[1] = snakeBody.peekLast()[1] + 1;
				} else if (dir == 2) {
					body[0] = snakeBody.peekLast()[0];
					body[1] = snakeBody.peekLast()[1] - 1;
				} else if (dir == 1) {
					body[0] = snakeBody.peekLast()[0] + 1;
					body[1] = snakeBody.peekLast()[1];
				} else if (dir == 3) {
					body[0] = snakeBody.peekLast()[0] - 1;
					body[1] = snakeBody.peekLast()[1];
				} else {
					System.out.println("���� ��ȯ ���");
				}
			}
			
			snakeBody.add(body);
			
			if (arr[snakeBody.peekLast()[0]][snakeBody.peekLast()[1]] == -1) {
				time++;
				System.out.println(time);
				end = true;
			}
			
			for (int i = snakeBody.size()-2; i >= 0; i--) {
				
				if (snakeBody.peekLast()[0] == snakeBody.get(i)[0] && snakeBody.peekLast()[1] == snakeBody.get(i)[1]) {
					time++;
					System.out.println(time);
					end = true;
				}
			}
			
			if (arr[snakeBody.peekLast()[0]][snakeBody.peekLast()[1]] == 1) {
				arr[snakeBody.peekLast()[0]][snakeBody.peekLast()[1]]=0;
			} else {

				snakeBody.remove(0);
			}

		}	

	}

}
