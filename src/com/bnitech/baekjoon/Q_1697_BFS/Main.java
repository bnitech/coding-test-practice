package Q_1697_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX = 100000; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num_N = Integer.parseInt(st.nextToken());
		int num_K = Integer.parseInt(st.nextToken());

		int[] memo_time = new int[MAX+1];
		
		Queue<Point> queue_N = new LinkedList<>();
		
		queue_N.offer(new Point(num_N,0));
		
		while(queue_N.isEmpty() != true) {
			Point poll_point = queue_N.poll();
			
			memo_time[poll_point.N] = poll_point.time;
			
			if(poll_point.N == num_K) break;
			
			int next_N = poll_point.N + 1;
			if(next_N <= MAX && memo_time[next_N] == 0) {
				queue_N.offer(new Point(next_N,poll_point.time+1));
			}
			
			next_N = poll_point.N -1;
			if( next_N >= 0 && memo_time[next_N] == 0) {
				queue_N.offer(new Point(next_N,poll_point.time+1));
			}
			
			next_N = poll_point.N * 2;
			if(next_N <= MAX && memo_time[next_N] == 0) {
				queue_N.offer(new Point(next_N,poll_point.time+1));
			}
			
		}
		
		bw.write(String.valueOf(memo_time[num_K]));
		bw.flush();

	}
	public static class Point{
		int N, time;
		public Point(int N, int time) {
			this.N = N;
			this.time = time;
		}
	}
}
