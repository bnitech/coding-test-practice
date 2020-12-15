package Q_1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num_N = Integer.parseInt(st.nextToken());
		int num_K = Integer.parseInt(st.nextToken());

		int count_Time = 0;
		
		if (num_K <= num_N) {
			//모두 걷기 (N-1)
			count_Time = num_N - num_K;
			System.out.println(num_N);
		} else {
			while (num_N != num_K) {
				
				int before_len = num_K - num_N;
				
				// 순간이동 할까?
				int after_len = num_K - (2*num_N);
				if(before_len > Math.abs(after_len)){
					//순간이동 실행
					num_N = 2*num_N;
					count_Time++;
					if(after_len < 0) {
						//모두 걷기 (N-1)
						num_N += after_len;
						count_Time += (-1)*after_len;
						continue;
					}
				}else {
					//걷기 (N+1)
					num_N ++;
					count_Time++;
				}
			}
		}

		bw.write(String.valueOf(count_Time));
		bw.flush();
	}
}
