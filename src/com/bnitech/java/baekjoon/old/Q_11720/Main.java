package Q_11720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int len = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += str.charAt(i) - '0';
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}
