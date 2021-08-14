package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Node3 implements Comparable<Node3> {
	int node;
	int cost;
	
	Node3(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node3 o) {
		return cost - o.cost;
	}
}
public class Main_1504_특정한최단경로 {
	
	static int N, E;
	static int[] dist;
	static boolean[] check;
	static final int INF = 20000000;
	static ArrayList<ArrayList<Node3>> list;
	
	private static int dijstra(int st, int ed) {

		// 초기화
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Node3> pq = new PriorityQueue<Node3>();
		
		pq.add(new Node3(st, 0));
		dist[st] = 0;
		check[st] = true;
		
		while(!pq.isEmpty()) {
			Node3 cur = pq.poll();
			
			for(Node3 tmp : list.get(cur.node)) {
				if(!check[tmp.node] && dist[tmp.node] > dist[cur.node] + tmp.cost) {
					dist[tmp.node] = dist[cur.node] + tmp.cost;
					check[cur.node] = true;
					pq.add(new Node3(tmp.node, dist[tmp.node]));
				}
			}
		}
		return dist[ed];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());
		
		dist = new int[N + 1];
		check = new boolean[N + 1];
		
		list = new ArrayList<ArrayList<Node3>>();
	
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node3>());
		}
		
		for(int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			
			list.get(st).add(new Node3(ed, cost));
			list.get(ed).add(new Node3(st, cost));
		}
		
		str = new StringTokenizer(br.readLine());
		int target1 = Integer.parseInt(str.nextToken());
		int target2 = Integer.parseInt(str.nextToken());
		
		int route1 = 0;
		int route2 = 0;
		
		route1 += dijstra(1, target1);
		route2 += dijstra(1, target2);
		
		route1 += dijstra(target1, target2);
		route2 += dijstra(target2, target1);
		
		route1 += dijstra(target2, N);
		route2 += dijstra(target1, N);
		
		if(route1 >= INF && route2 >= INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(Math.min(route1, route2));
		}
	}
}
