package Q_15719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num_N = Integer.parseInt(br.readLine());
		boolean[] check_N = new boolean[num_N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num_N; i++) {
			int find_N = Integer.parseInt(st.nextToken());
			if (check_N[find_N] == false) {
				check_N[find_N] = true;
			} else {
				bw.write(String.valueOf(find_N));
				break;
			}
		}

		bw.flush();
	}
}
