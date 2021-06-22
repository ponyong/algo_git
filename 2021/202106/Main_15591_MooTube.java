package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 

public class Main_15591_MooTube {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int Q = Integer.parseInt(str.nextToken());
		
		List<int[]>[] list = new ArrayList[N + 1];
		StringBuilder sb = new StringBuilder();
		boolean[] visit;
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i = 1; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			int val = Integer.parseInt(str.nextToken());
			
			list[u].add(new int[] { v, val });
			list[v].add(new int[] { u, val });
		}
		
		for(int i = 0 ; i < Q; i++) {
			str = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(str.nextToken());
			int V = Integer.parseInt(str.nextToken());
			int cnt = 0;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			visit = new boolean[N + 1];
			queue.add(V);
			visit[V] = true;
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				for(int[] next : list[cur]) {
					int node = next[0];
					int value = next[1];
					
					if(!visit[node] && value >= K) {
						queue.add(node);
						visit[node] = true;
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}
