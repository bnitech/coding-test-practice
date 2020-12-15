import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_2193().start(br);
	}

	private void start(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numN = Integer.parseInt(st.nextToken());

		long[] count = new long[numN+1];
		
		count[1] = 1;
		
		for (int i = 2; i <= numN; i++) {
			count[i] = count[i-1] + count[i-2];
		}
		
		System.out.println(count[numN]);
		
	}
}
