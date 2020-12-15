package Q_1937;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main ex = new Main();

		System.out.println(ex.solution());
	}

	public int solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numN = Integer.parseInt(br.readLine());

		int[][] mapArr = new int[numN][numN];

		StringTokenizer st = new StringTokenizer("");
		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < numN; j++) {
				mapArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int[][] cntDayArr = new int[numN][numN];

		int maxDay = 0;
		for (int i = 0; i < numN; i++) {
			for (int j = 0; j < numN; j++) {

				Queue<Point> queuePoint = new LinkedList<>();

				if (cntDayArr[i][j] == 0) {
					queuePoint.offer(new Point(j, i, 1));
				}

				while (queuePoint.isEmpty() == false) {
					Point curPoint = queuePoint.poll();
					if(maxDay < curPoint.day) {
						maxDay = curPoint.day;
					}

					for (int k = 0; k < 4; k++) {
						int nextX = curPoint.X + dx[k];
						int nextY = curPoint.Y + dy[k];

						if (nextY >= 0 && nextY < numN && nextX >= 0 && nextX < numN) {
							if (mapArr[curPoint.Y][curPoint.X] < mapArr[nextY][nextX]) {
								if (curPoint.day >= cntDayArr[nextY][nextX]) {
									queuePoint.offer(new Point(nextX, nextY, curPoint.day + 1));
									cntDayArr[nextY][nextX] = curPoint.day+1;
								}
							}
						}
					}
				}

			}
		}

		return maxDay;
	}

	public class Point {
		int X, Y, day;

		public Point(int X, int Y, int day) {
			this.X = X;
			this.Y = Y;
			this.day = day;
		}
	}
}
