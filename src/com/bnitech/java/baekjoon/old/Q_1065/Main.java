package Q_1065;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_N = Integer.parseInt(br.readLine());
		int[] memo_N = new int[num_N + 1];

		
		
		for (int i = 1; i <= num_N; i++) {
			if (i < 100) memo_N[i] = i;
			else {
				char[] chars_N = String.valueOf(i).toCharArray();
				
				int gap = chars_N[1] - chars_N[0];
				
				boolean isOK = true;
				for (int j = 1; j < chars_N.length-1; j++) {
					if(gap != chars_N[j+1] - chars_N[j]) {
						isOK = false;
					}
				}
				
				if(isOK == true){
					memo_N[i] = memo_N[i-1] + 1;
				}else {
					memo_N[i] = memo_N[i-1];
				}
			
//				System.out.println(i+"/"+memo_N[i]);
			}
			 
		}
		
		System.out.println(memo_N[num_N]);
	}
}
