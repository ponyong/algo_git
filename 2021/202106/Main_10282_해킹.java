package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_10282_해킹 {
	static int n, d;
	static int[] dist;
	static List<Com>[] list;
	static final int INF = 987654321;
	public static class Com implements Comparable<Com>{
		int num;
		int cost;
		
		public Com(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Com o) {
			return this.cost - o.cost;
		}
	}
	private static void dijkstra(int st) {
		
		PriorityQueue<Com> pq = new PriorityQueue<Com>(new Comparator<Com>() {

			@Override
			public int compare(Com o1, Com o2) {
				return o2.cost - o1.cost;
			}
		});
		
		dist[st] = 0;
		pq.add(new Com(st, dist[st]));
		
		while(!pq.isEmpty()) {
			Com cur = pq.poll();
			
			if(cur.cost > dist[cur.num]) {
				continue;
			}
			
			for(Com next : list[cur.num]) {
				if(dist[next.num] > dist[cur.num] + next.cost) {
					dist[next.num] = dist[cur.num] + next.cost;
					pq.add(new Com(next.num, dist[next.num]));
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;
		for(int tc = 0; tc < TC; tc++) {
			str = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(str.nextToken()); // 컴퓨터 개수
			d = Integer.parseInt(str.nextToken()); // 의존성 개수
			int c = Integer.parseInt(str.nextToken()); // 시작 컴퓨터
		
			dist = new int[n + 1];
			list = new ArrayList[n + 1];
			
			for(int i = 1; i <= n; i++) {
				list[i] = new ArrayList<Com>();
			}
			Arrays.fill(dist, INF);
			
			for(int i = 0; i < d; i++) {
				str = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				int s = Integer.parseInt(str.nextToken());
			
				list[b].add(new Com(a, s));
			}
			dijkstra(c);
	
			int cnt = 0;
			int max = 0;
			for(int i = 1; i <= n; i++) {
				if(dist[i] != INF) {
					cnt++;
					max = Math.max(max, dist[i]);
				}
			}
			bw.write(cnt + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
}
