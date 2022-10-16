import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Nodes {
	int col, row, dep;

	Nodes(int row, int col,  int dep) {
		this.row = row;
		this.col = col;
		this.dep = dep;
	}
}

public class Q_2636 {
	int numN, numM;
	int maxDep = 0, count =0;

	int[][] matrix;
	boolean[][] vist;

	Deque<Nodes> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_2636().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		numN = Integer.parseInt(st.nextToken());
		numM = Integer.parseInt(st.nextToken());

		list = new LinkedList<Nodes>();
		matrix = new int[numN][numM];
		vist = new boolean[numN][numM];

		for (int i = 0; i < numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < numM; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		
		findNode();

		System.out.println(maxDep);
		System.out.println(count);
	}

	void findNode() {
		
		int row = 0, col = 0, dep = 0;

		int[] MOVE_ROW = { 1, 0, -1, 0 };
		int[] MOVE_COL = { 0, 1, 0, -1 };

		list.offer(new Nodes(row, col, dep));
		vist[row][col] = true;

		while (!list.isEmpty()) {
			Nodes node = list.pollFirst();
			row = node.row;
			col = node.col;
			dep = node.dep;
			
			if(maxDep == dep){
				count++;
			}
			if (maxDep < dep){
				maxDep = dep;
				System.out.println(maxDep);
				count = 1;
			}
			
			
			for (int i = 0; i < 4; i++) { // »óÇÏÁÂ¿ì
				int nextRow = row + MOVE_ROW[i];
				int nextCol = col + MOVE_COL[i];

				if (nextRow >= numN)
					continue;
				if (nextCol >= numM)
					continue;
				if (nextRow < 0)
					continue;
				if (nextCol < 0)
					continue;
				if (vist[nextRow][nextCol])
					continue;

				int nextDep = matrix[nextRow][nextCol];
				
				

				if (nextDep == 0) {
					if (maxDep > nextDep) {
						list.offerFirst(new Nodes(nextRow, nextCol, dep));
					} else {
						list.offerLast(new Nodes(nextRow, nextCol, dep));
					}
				} else {
					if (maxDep > nextDep) {
						list.offerFirst(new Nodes(nextRow, nextCol, dep+1));
					} else {
						list.offerLast(new Nodes(nextRow, nextCol, dep+1));
					}
				}
				vist[nextRow][nextCol] = true;
				
			}

		}
	}
}
