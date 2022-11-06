import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_170402 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_170402().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numN = Integer.parseInt(st.nextToken());

		minMuti(numN);
	}

	void minMuti(int numN) {
		int[][] matrix = { { 0, 0 }, { 5, 2 }, { 2, 3 }, { 3, 4 }, { 4, 6 }, { 6, 7 }, { 7, 8 } };
		int[][] dpMatrix = new int[numN + 1][numN + 1];

		for (int j = 2; j <= numN; j++) {
			for (int i = j - 1; i >= 1; i--) {
				int min = 1000000000;
				for (int k = i; k <= j - 1; k++) {
					if (min > dpMatrix[i][k] + dpMatrix[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1])
						min = dpMatrix[i][k] + dpMatrix[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
				}
				dpMatrix[i][j] = min;
			}
		}

		System.out.println(dpMatrix[1][numN]);
	}
}
