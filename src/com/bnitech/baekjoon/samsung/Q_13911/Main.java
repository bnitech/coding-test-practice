package Q_13911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		System.out.println(main.solution());
	}

	public int solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numVertex = Integer.parseInt(st.nextToken());
		int numEdge = Integer.parseInt(st.nextToken());

		// minM, minS, type : 1-M, 2-S
		int[][] vertexArr = new int[numVertex + 1][3];

		List<HashMap<Integer, Integer>> edgeList = new ArrayList<>();
		for (int i = 0; i <= numVertex; i++) {
			edgeList.add(new HashMap<>());
		}
		for (int i = 0; i < numEdge; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			edgeList.get(L).put(R, V);
			edgeList.get(R).put(L, V);
		}

		List<Point>[] startList = new ArrayList[2];
		startList[0] = new ArrayList<>();
		startList[1] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int lenM = Integer.parseInt(st.nextToken());
		int maxCostM = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lenM; i++) {
			int numM = Integer.parseInt(st.nextToken());
			// type 1
			vertexArr[numM][2] = 1;
			// startVertex
			startList[0].add(new Point(numM, 0, 1));

		}

		st = new StringTokenizer(br.readLine());
		int lenS = Integer.parseInt(st.nextToken());
		int maxCostS = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lenS; i++) {
			int numS = Integer.parseInt(st.nextToken());
			// type 2
			vertexArr[numS][2] = 2;
			// startVertex
			startList[1].add(new Point(numS, 0, 2));
		}

		for (int i = 0; i < 2; i++) {

			Queue<Point> queueVertex = new LinkedList<>();
			for (Point point : startList[i]) {
				queueVertex.offer(point);
			}

			boolean[] checkVertex = new boolean[numVertex + 1];

			while (queueVertex.isEmpty() == false) {
				Point pollPoint = queueVertex.poll();
				
				for (int key : edgeList.get(pollPoint.num).keySet()) {
					int curSum = pollPoint.sum;
					if (vertexArr[key][2] != 0 || checkVertex[key] == true) {
						continue;
					}
					curSum += edgeList.get(pollPoint.num).get(key);
					if (pollPoint.type == 1) {
						if (vertexArr[key][0] > curSum || vertexArr[key][0] == 0) {
							vertexArr[key][0] = curSum;
							queueVertex.offer(new Point(key, curSum, pollPoint.type));
							checkVertex[key] = true;
						}
					} else if (pollPoint.type == 2) {
						if (vertexArr[key][1] > curSum || vertexArr[key][1] == 0) {
							vertexArr[key][1] = curSum;
							queueVertex.offer(new Point(key, curSum, pollPoint.type));
							checkVertex[key] = true;
						}
					}
					
				}
			}

		}

		int[] minVetex = new int[2];
		minVetex[1] = Integer.MAX_VALUE;
		for (int i = 1; i <= numVertex; i++) {
			if (vertexArr[i][2] > 0)
				continue;
			if (vertexArr[i][0] <= maxCostM && vertexArr[i][1] <= maxCostS) {
				int sum = vertexArr[i][0] + vertexArr[i][1];
				if (minVetex[1] > sum) {
					minVetex[1] = sum;
					minVetex[0] = i;
				}
			}
		}

		if (minVetex[0] == 0 || minVetex[1] == 0) {
			return -1;
		}
		return minVetex[1];
	}

	public class Point {
		int num, sum, type;

		public Point(int num, int sum, int type) {
			this.num = num;
			this.sum = sum;
			this.type = type;
		}
	}
}
