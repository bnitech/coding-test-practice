package CCTV감시_DFS조합수열응용;

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

		// map 초기화, CCTV 위치 저장
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

		// 방향 초기화
		// 우 하 좌 상
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		dirHM = new HashMap<>();
		int[] tmp = new int[2];
		tmp[DX] = dx[0];
		tmp[DY] = dy[0];
		dirHM.put("우", tmp);
		tmp = new int[2];
		tmp[DX] = dx[1];
		tmp[DY] = dy[1];
		dirHM.put("하", tmp);
		tmp = new int[2];
		tmp[DX] = dx[2];
		tmp[DY] = dy[2];
		dirHM.put("좌", tmp);
		tmp = new int[2];
		tmp[DX] = dx[3];
		tmp[DY] = dy[3];
		dirHM.put("상", tmp);

		// CCTV 방향 경우의 수(조합) 구하기
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
				// 현 위치에서 새로 시작
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
		// 이동가능한 방향으로 흔적 남기며 이동
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
		// 4가지 : 우, 하, 좌, 상
		case 1:
			if (dir == 0) {
				dirList.add(dirHM.get("우"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("하"));
			} else if (dir == 2) {
				dirList.add(dirHM.get("좌"));
			} else if (dir == 3) {
				dirList.add(dirHM.get("상"));
			}
			break;
		// 2가지 : 상 하, 좌 우
		case 2:
			if (dir == 0) {
				dirList.add(dirHM.get("상"));
				dirList.add(dirHM.get("하"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("좌"));
				dirList.add(dirHM.get("우"));
			}
			break;
		// 4가지 : 상 우, 우 하, 하 좌, 좌 상
		case 3:
			if (dir == 0) {
				dirList.add(dirHM.get("상"));
				dirList.add(dirHM.get("우"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("우"));
				dirList.add(dirHM.get("하"));
			} else if (dir == 2) {
				dirList.add(dirHM.get("하"));
				dirList.add(dirHM.get("좌"));
			} else if (dir == 3) {
				dirList.add(dirHM.get("좌"));
				dirList.add(dirHM.get("상"));
			}
			break;
		// 4가지 : 상 우 하, 우 하 좌 , 하 좌 상, 좌 상 우
		case 4:
			if (dir == 0) {
				dirList.add(dirHM.get("상"));
				dirList.add(dirHM.get("우"));
				dirList.add(dirHM.get("하"));
			} else if (dir == 1) {
				dirList.add(dirHM.get("우"));
				dirList.add(dirHM.get("하"));
				dirList.add(dirHM.get("좌"));
			} else if (dir == 2) {
				dirList.add(dirHM.get("하"));
				dirList.add(dirHM.get("좌"));
				dirList.add(dirHM.get("상"));
			} else if (dir == 3) {
				dirList.add(dirHM.get("좌"));
				dirList.add(dirHM.get("상"));
				dirList.add(dirHM.get("우"));
			}
			break;
		// 4가지 : 상 우 하 좌
		case 5:
			if (dir == 0) {
				dirList.add(dirHM.get("우"));
				dirList.add(dirHM.get("하"));
				dirList.add(dirHM.get("좌"));
				dirList.add(dirHM.get("상"));
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
