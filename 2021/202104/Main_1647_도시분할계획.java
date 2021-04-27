package Algo_Study_BOJ;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

	int r;
	int c;
	int cost;
	
	public Edge(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
	
}
public class Main_1647_도시분할계획 {
	static int N, M;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	
	private static void union(int r, int c) {
		int rRoot = find(r);
		int cRoot = find(c);
		
		if(rRoot < cRoot) {
			parent[rRoot] = cRoot;
		}
		else {
			parent[cRoot] = rRoot;
		}
	}
	private static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]);			
		}
	}
	private static int Kruskal() {
		int sum = 0; 
		int choice = 0;
		
		while(choice < N - 2) {
			Edge tmp = pq.poll();
			
			if(find(tmp.r) != find(tmp.c)) {
				sum += tmp.cost;
				choice++;
				union(tmp.r , tmp.c);
			}
		}
		return sum;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			
			pq.add(new Edge(st, ed, cost));
		}
		
		System.out.println(Kruskal());
	}
}
