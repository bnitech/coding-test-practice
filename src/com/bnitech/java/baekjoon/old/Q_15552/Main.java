package Q_15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num_T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		while(num_T -- > 0) {
			 st = new StringTokenizer(br.readLine());
			 int A = Integer.parseInt(st.nextToken());
			 int B = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(A+B));
			bw.newLine();
		}
		bw.flush();
	}
}
