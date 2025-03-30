package Q_2962;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_T = Integer.parseInt(br.readLine());
		
		int num_N = Integer.parseInt(br.readLine());
		int[][] arr_N = new int[num_N][2];
		
		StringTokenizer st = null;
		for (int i = 0; i < num_N; i++) {
			st = new StringTokenizer(br.readLine());
			arr_N[i][0] = Integer.parseInt(st.nextToken());
			arr_N[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int num_M = Integer.parseInt(br.readLine());
		int[][] arr_M = new int[num_N][2];
		
		for (int i = 0; i < num_M; i++) {
			st = new StringTokenizer(br.readLine());
			arr_M[i][0] = Integer.parseInt(st.nextToken());
			arr_M[i][1] = Integer.parseInt(st.nextToken());
		}
	
		int num_K=0;
		long sum_T=0;
		
		//적합한 K찾기
		while(true) {
			num_K++;
			
			//첫번째 원숭이들
			long max_first_T=0;
			for (int i = 0; i < num_N; i++) {
				int first_T = arr_N[i][0] + num_K*arr_N[i][1];
				if(max_first_T < first_T) max_first_T = first_T;
			}
			
			//두번째 원숭이들
			long max_second_T=0;
			for (int i = 0; i < num_M; i++) {
				int second_T = arr_M[i][0] + num_K*arr_M[i][1];
				if(max_second_T < second_T) max_second_T = second_T;
			}
				
			sum_T = max_first_T + max_second_T;
			
			if(num_T == sum_T) {
				System.out.println(max_first_T);
				break;
			}
			System.out.println(num_K);
		}
	}
}
