import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_170403_flow {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_170403_flow().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());
		// int[][] matrix = { { 0, 0 }, { 5, 2 }, { 2, 3 }, { 3, 4 }, { 4, 6 },
		// { 6, 7 }, { 7, 8 } };
		int[][] matrix = new int[numN + 1][2];
		for (int i = 1; i <= numN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= 1; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minMuti(numN, matrix);
	}

	void minMuti(int numN, int[][] matrix) {

		int[][] dpMatrix = new int[numN + 1][numN + 1];
		int[][][] flowMatrix = new int[numN + 1][numN + 1][4]; // ( )->( )

		for (int j = 2; j <= numN; j++) {
			for (int i = j - 1; i >= 1; i--) {
				int min = dpMatrix[i][i] + dpMatrix[i + 1][j] + matrix[i][0] * matrix[i][1] * matrix[j][1];
				for (int k = i; k <= j - 1; k++) {
					int temp = dpMatrix[i][k] + dpMatrix[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
					if (min >= temp) {
						min = temp;
						flowMatrix[i][j][0] = i;
						flowMatrix[i][j][1] = k;
						flowMatrix[i][j][2] = k + 1;
						flowMatrix[i][j][3] = j;
					}
				}
				dpMatrix[i][j] = min;
			}
		}
		for (int j = 1; j <= numN; j++) {
			for (int i = 1; i <= numN; i++) {
				//for (int k = 0; k < 4; k++) {
					//System.out.print(flowMatrix[j][i][k]);
					System.out.print(dpMatrix[j][i]);
				//}
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int j = 1; j <= numN; j++) {
			for (int i = 1; i <= numN; i++) {
				for (int k = 0; k < 4; k++) {
					System.out.print(flowMatrix[j][i][k]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}

		printFlow(flowMatrix, 1, numN);
		System.out.println();
		System.out.println(dpMatrix[1][numN]);
	}

	void printFlow(int[][][] flowMatrix, int i, int j) {
		System.out.print("(");
		
		if (flowMatrix[i][j][0] == flowMatrix[i][j][1]) {
			System.out.print(flowMatrix[i][j][0]);
		} else {
			printFlow(flowMatrix, flowMatrix[i][j][0], flowMatrix[i][j][1]);
		}
		
		if (flowMatrix[i][j][2] == flowMatrix[i][j][3]) {
			System.out.print(flowMatrix[i][j][2]);
		} else {
			printFlow(flowMatrix, flowMatrix[i][j][2], flowMatrix[i][j][3]);
		}

		System.out.print(")");
	}
}
