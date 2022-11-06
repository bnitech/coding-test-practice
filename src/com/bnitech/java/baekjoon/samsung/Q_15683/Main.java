package com.bnitech.java.baekjoon.samsung.Q_15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		System.out.println(main.solution());

	}

	static final int DX = 0;
	static final int DY = 1;
	static int numN, numM, minCntArea = Integer.MAX_VALUE;
	static HashMap<String, int[]> dirHM;

	public int solution() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		numN = Integer.parseInt(st.nextToken());
		numM = Integer.parseInt(st.nextToken());

		// map �ʱ�ȭ, CCTV ��ġ ����
		int[][] mapArr = new int[numN][numM];

		ArrayList<Point> cctvList = new ArrayList<>();

		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < numM; j++) {
				int num = Integer.parseInt(st.nextToken());
				mapArr[i][j] = num;
				if (num > 0 && num < 6) {
					cctvList.add(new Point(j, i, num));
				}
			}
		}

		// ���� �ʱ�ȭ
		// �� �� �� ��
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		dirHM = new HashMap<>();
		int[] tmp = new int[2];
		tmp[DX] = dx[0];
		tmp[DY] = dy[0];
		dirHM.put("��", tmp);
		tmp = new int[2];
		tmp[DX] = dx[1];
		tmp[DY] = dy[1];
		dirHM.put("��", tmp);
		tmp = new int[2];
		tmp[DX] = dx[2];
		tmp[DY] = dy[2];
		dirHM.put("��", tmp);
		tmp = new int[2];
		tmp[DX] = dx[3];
		tmp[DY] = dy[3];
		dirHM.put("��", tmp);

		// CCTV ���� ����� ��(����) ���ϱ�
		int[][] tmpMapArr = new int[numN][numM];
		for (int i = 0; i < numN; i++) {
			tmpMapArr[i] = mapArr[i].clone();
		}

		boolean[][] checkedCctv = new boolean[cctvList.size()][4];
		combination_dfs(0, cctvList, tmpMapArr, checkedCctv);

		return minCntArea;
	}

	public void combination_dfs(int idx, ArrayList<Point> cctvList, int[][] tmpMapArr, boolean[][] checkedCctv) {
		if (cctvList.size() == idx) {
			int cntArea = countArea(tmpMapArr);
			if (minCntArea > cntArea) {
				minCntArea = cntArea;
			}

			return;
		}

		Point curPoint = cctvList.get(idx);
		int[][] nextMapArr = new int[numN][numM];
		for (int j = 0; j < numN; j++) {
			nextMapArr[j] = tmpMapArr[j].clone();
		}
		
		switch (curPoint.type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				checkedCctv[idx][i] = true;
				nextMapArr = setArea(nextMapArr, curPoint, i);
				combination_dfs(idx + 1, cctvList, nextMapArr, checkedCctv);
				// �� ��ġ���� ���� ����
				for (int j = 0; j < numN; j++) {
					nextMapArr[j] = tmpMapArr[j].clone();
				}
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				checkedCctv[idx][i] = true;
				nextMapArr = setArea(nextMapArr, curPoint, i);
				combination_dfs(idx + 1, cctvList, nextMapArr, checkedCctv);
				for (int j = 0; j < numN; j++) {
					nextMapArr[j] = tmpMapArr[j].clone();
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				checkedCctv[idx][i] = true;
				nextMapArr = setArea(nextMapArr, curPoint, i);
				combination_dfs(idx + 1, cctvList, nextMapArr, checkedCctv);
				for (int j = 0; j < numN; j++) {
					nextMapArr[j] = tmpMapArr[j].clone();
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				checkedCctv[idx][i] = true;
				nextMapArr = setArea(nextMapArr, curPoint, i);
				combination_dfs(idx + 1, cctvList, nextMapArr, checkedCctv);
				for (int j = 0; j < numN; j++) {
					nextMapArr[j] = tmpMapArr[j].clone();
				}
			}
			break;
		case 5:
			checkedCctv[idx][0] = true;
			nextMapArr = setArea(nextMapArr, curPoint, 0);
			combination_dfs(idx + 1, cctvList, nextMapArr, checkedCctv);
			for (int j = 0; j < numN; j++) {
				nextMapArr[j] = tmpMapArr[j].clone();
			}
			break;
		default:
			break;
		}
	}

	public int countArea(int[][] tmpMapArr) {
		int cntArea = 0;
		for (int i = 0; i < numN; i++) {
			for (int j = 0; j < numM; j++) {
				if (tmpMapArr[i][j] == 0) {
					cntArea++;
				}
			}
		}
		return cntArea;
	}

	public int[][] setArea(int[][] tmpMapArr, Point curPoint, int dir) {
		// �̵������� �������� ���� ����� �̵�
		ArrayList<int[]> curDirList = setDirList(curPoint.type, dir);
		tmpMapArr[curPoint.Y][curPoint.X] = curPoint.type;
		for (int[] curDir : curDirList) {

			int nextX = curPoint.X + curDir[DX];
			int nextY = curPoint.Y + curDir[DY];
			while (nextY >= 0 && nextY < numN && nextX >= 0 && nextX < numM) {

				if (tmpMapArr[nextY][nextX] != 6) {
					tmpMapArr[nextY][nextX] = curPoint.type;
				} else {
					break;
				}
				nextX += curDir[DX];
				nextY += curDir[DY];

//				System.out.println("---------------" + curDir[0] + "/" + curDir[1] + "---------------------");
//				for (int i = 0; i < numN; i++) {
//					System.out.println(Arrays.toString(tmpMapArr[i]));
//				}
			}
		}

		return tmpMapArr;
	}

	public ArrayList<int[]> setDirList(int type, int dir) {
		ArrayList<int[]> dirList = new ArrayList<>();
		switch (type) {
		// 4���� : ��, ��, ��, ��
		case 1:
			if (dir == 0) {
				dirList.add(dirHM.get("��"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("��"));
			} else if (dir == 2) {
				dirList.add(dirHM.get("��"));
			} else if (dir == 3) {
				dirList.add(dirHM.get("��"));
			}
			break;
		// 2���� : �� ��, �� ��
		case 2:
			if (dir == 0) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			}
			break;
		// 4���� : �� ��, �� ��, �� ��, �� ��
		case 3:
			if (dir == 0) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 2) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 3) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			}
			break;
		// 4���� : �� �� ��, �� �� �� , �� �� ��, �� �� ��
		case 4:
			if (dir == 0) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 2) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			} else if (dir == 3) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			}
			break;
		// 4���� : �� �� �� ��
		case 5:
			if (dir == 0) {
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
				dirList.add(dirHM.get("��"));
			}
			break;

		default:
			break;
		}

		return dirList;
	}

	public class Point {
		int X, Y, type;

		public Point(int X, int Y, int type) {
			this.X = X;
			this.Y = Y;
			this.type = type;
		}
	}
}
