package Q_4344;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_T = Integer.parseInt(br.readLine());

		while (num_T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num_N = Integer.parseInt(st.nextToken());
			int[] arr_N = new int[num_N];
			int sum = 0, avg = 0;
			for (int i = 0; i < num_N; i++) {
				int su = Integer.parseInt(st.nextToken());
				arr_N[i] = su;
				sum += su;
			}
			avg = sum / num_N;

			float count = 0;
			for (int i = 0; i < num_N; i++) {
				if (avg < arr_N[i]) count++;
			}

			float result = count / num_N * 100;
			System.out.format("%.3f%%\n", result);

		}

	}
}
