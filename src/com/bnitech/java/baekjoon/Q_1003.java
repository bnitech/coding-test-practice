import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1003 {
	public static int count_0 = 0;
	public static int count_1 = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		new Q_1003().start(br);
	}
	
	void start(BufferedReader br) throws Exception {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numT = Integer.parseInt(st.nextToken());
		
		
		
		for (int i = 0; i < numT; i++) {
		
			st = new StringTokenizer(br.readLine());
			int numN = Integer.parseInt(st.nextToken());
			
			fibonacci(numN);

			System.out.println(count_0+" "+count_1);
			
			count_0 = 0;
			count_1 = 0;
		}
		
	}
	public int fibonacci(int n) {
	    if (n==0) {
	    	count_0++;
	        return 0;
	    } else if (n==1) {
	    	count_1++;
	        return 1;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}
}
