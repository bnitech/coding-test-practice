/*
�Ｚ SW ���� �׽�Ʈ ���� ����
��Ϲ���
 */

package com.bnitech.java.baekjoon.samsung.acmicpc_14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character>[] link_NS = new LinkedList[4];

		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			link_NS[i] = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				link_NS[i].add(str.charAt(j));
			}
		}

		int num_N = Integer.parseInt(br.readLine());
		for (int i = 0; i < num_N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_link = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			boolean[] check_link = new boolean[4];
			
			Queue<Cycle> queue = new LinkedList<>();
			queue.add(new Cycle(start_link, dir));
			check_link[start_link] = true;
			
			
			while(queue.isEmpty() == false) {
				Cycle poll_cycle = queue.poll();
				
//				System.out.println("Cycle : "+poll_cycle.link+" = "+poll_cycle.dir);
			
				if(poll_cycle.link == 0) {
					if(link_NS[poll_cycle.link].get(2) != link_NS[1].get(6) && check_link[1] == false ){
						queue.add(new Cycle(1, poll_cycle.dir*(-1)));
					}
				}else if(poll_cycle.link == 1) {
					if(link_NS[poll_cycle.link].get(2) != link_NS[2].get(6) && check_link[2] == false ){
						queue.add(new Cycle(2, poll_cycle.dir*(-1)));
					}
					if(link_NS[poll_cycle.link].get(6) != link_NS[0].get(2) && check_link[0] == false ){
						queue.add(new Cycle(0, poll_cycle.dir*(-1)));
					}
				}else if(poll_cycle.link == 2) {
					if(link_NS[poll_cycle.link].get(2) != link_NS[3].get(6) && check_link[3] == false ){
						queue.add(new Cycle(3, poll_cycle.dir*(-1)));
					}
					if(link_NS[poll_cycle.link].get(6) != link_NS[1].get(2) && check_link[1] == false ){
						queue.add(new Cycle(1, poll_cycle.dir*(-1)));
					}
				}else if(poll_cycle.link == 3) {
					if(link_NS[poll_cycle.link].get(6) != link_NS[2].get(2) && check_link[2] == false ){
						queue.add(new Cycle(2, poll_cycle.dir*(-1)));
					}
				
				}
				
				
				if(poll_cycle.dir == 1) {
					char tmp =link_NS[poll_cycle.link].getLast();
					link_NS[poll_cycle.link].addFirst(tmp);
					link_NS[poll_cycle.link].removeLast();
				}else {
					char tmp =link_NS[poll_cycle.link].getFirst();
					link_NS[poll_cycle.link].addLast(tmp);
					link_NS[poll_cycle.link].removeFirst();
				}
				
				check_link[poll_cycle.link] = true;
				
//				for (int k = 0; k < 4; k++) {
//					System.out.println(link_NS[k]);
//				}
				
				
			}
//			System.out.println("----");

		}
		
		int sum =0;
		for (int i = 0; i < 4; i++) {
		
			char output = link_NS[i].getFirst();		
			if(output=='1') {
				sum += Math.pow(2,i);
			}
		}
		System.out.println(sum);
		
	}
	public static class Cycle{
		int link, dir;
		public Cycle(int link, int dir) {
			this.link = link;
			this.dir = dir;
		}
	}
}
