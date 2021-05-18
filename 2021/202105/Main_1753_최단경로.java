package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node5 implements Comparable<Node5> {
	int ed;
	int cost;
	
	public Node5(int ed, int cost) {
		this.ed = ed;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node5 o) {
		return cost - o.cost;
	}	
}
public class Main_1753_최단경로 {
	
	static List<Node5>[] list;
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());
		int[] dist = new int[V + 1];
		boolean[] check = new boolean[V + 1];
		list = new ArrayList[V + 1];
		
		Arrays.fill(dist, INF);
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			
			list[st].add(new Node5(ed, cost));
		}
		
		PriorityQueue<Node5> pq = new PriorityQueue<Node5>();
		
		pq.add(new Node5(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node5 cur = pq.poll();
			
			int pick = cur.ed;
			
			if(check[pick]) {
				continue;
			}
			check[pick] = true;
			
			for(Node5 next : list[pick]) {
				if(dist[next.ed] > dist[pick] + next.cost) {
					dist[next.ed] = dist[pick] + next.cost;
					pq.add(new Node5(next.ed, dist[next.ed]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				sb.append("INF\n");
			}
			else {
				sb.append(dist[i] + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
