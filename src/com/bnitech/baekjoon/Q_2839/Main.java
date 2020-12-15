package Q_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_N = Integer.parseInt(br.readLine());
		
		if(num_N < 5) {
			if(num_N == 3) System.out.println(1);
			else System.out.println(-1);
			return;
		}
		
		int memo_count[] = new int[num_N+1];
		
		memo_count[3] =1;
		memo_count[5] =1;
		
		for (int i = 6; i <= num_N; i++) {
			if(memo_count[i-5] == 0) {
				if(memo_count[i-3] == 0) {}
				else {
					memo_count[i] = memo_count[i-3]+1; 
				}
			}else {
				memo_count[i] = memo_count[i-5]+1;
			}
		}
		
		if(memo_count[num_N] == 0) System.out.println(-1);
		else System.out.println(memo_count[num_N]);
	}

}
