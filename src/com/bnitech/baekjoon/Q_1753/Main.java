package Q_1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX = 100000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num_V = Integer.parseInt(st.nextToken());
		int num_E = Integer.parseInt(st.nextToken());

		int start_V = Integer.parseInt(br.readLine());

		ArrayList<Vertex>[] arrList_V = new ArrayList[num_V + 1];
		for (int i = 1; i <= num_V; i++) {
			arrList_V[i] = new ArrayList<>();
		}

		for (int i = 0; i < num_E; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			arrList_V[U].add(new Vertex(V, W));
		}

		int[] min_value_V = new int[num_V + 1];

		Queue<Vertex> queue_V = new LinkedList<>();
		queue_V.offer(new Vertex(start_V, 0));

		while (queue_V.isEmpty() == false) {
			Vertex poll = queue_V.poll();
			int end_V = poll.V;
			int total_value = poll.value;

			if (min_value_V[end_V] == 0)
				min_value_V[end_V] = total_value;
			else if (min_value_V[end_V] > total_value)
				min_value_V[end_V] = total_value;
			else
				continue;

			for (int i = 0; i < arrList_V[end_V].size(); i++) {
				queue_V.offer(new Vertex(arrList_V[end_V].get(i).V, arrList_V[end_V].get(i).value + total_value));
			}

		}

		for (int i = 1; i <= num_V; i++) {
			if (min_value_V[i] == 0) {
				if (i != start_V) {
					bw.write("INF");
					continue;
				}
			}
			bw.write(String.valueOf(min_value_V[i]));
			bw.newLine();
		}

		bw.flush();
	}

	public static class Vertex {
		int V, value;

		public Vertex(int V, int value) {
			this.V = V;
			this.value = value;
		}
	}
}
