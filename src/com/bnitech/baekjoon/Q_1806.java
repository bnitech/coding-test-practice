

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q_1806().start(br);
	}

	private void start(BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numN = Integer.parseInt(st.nextToken());
		int numS = Integer.parseInt(st.nextToken());

		int[] arr = new int[numN];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < numN; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(twoPointer(arr, numN, numS));
	

	}

	public int twoPointer(int[] arr, int numN, int numS) {
		int right = 0, left = 0;
		int sum = 0, len = numN, tmpLen = 0;
		while (right <= numN) {
			if (sum < numS) {
				if(right==numN){
					if(arr[right-1]>=numS){
						len = 1;	
					}else{
						len = 0;
					}
					right++;
					
				}else{
					sum += arr[right++];	
				}
				
					
			} else if (sum >= numS) {
				while(left<right){
					sum -= arr[left++];
					if(sum<numS){
						break;
					}
					tmpLen = right - left;
					if (len > tmpLen) {
						len = tmpLen;
					}
				}
			}
		}
		
		return len;
	}
}
