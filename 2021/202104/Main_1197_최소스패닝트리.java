package Algo_Study_BOJ;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node8 implements Comparable<Node8>{

	int st;
	int ed;
	int val;
	
	public Node8(int st, int ed, int val) {
		this.st = st;
		this.ed = ed;
		this.val = val;
	}
	
	@Override
	public int compareTo(Node8 o) {
		return this.val - o.val;
	}
	
}
public class Main_1197_최소스패닝트리 { 
	static int[] parent;
	public static int find(int x) {
		
		if(x == parent[x]) {
			return x;
		}
		
		parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	public static void union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot != yRoot) {
			parent[xRoot] = y;
		}
		else {
			return;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());
		int answer = 0;
		PriorityQueue<Node8> pq = new PriorityQueue<Node8>();
		parent = new int[V + 1];
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
 		} 
		
		for(int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int val = Integer.parseInt(str.nextToken());
			
			pq.add(new Node8(st, ed, val));
		}
		
		for(int i = 0; i < E; i++) {
			Node8 cur = pq.poll();
			
			int x = find(cur.st);
			int y = find(cur.ed);
			
			if(x == y) {
				continue;
			}
			union(x, y);
			
			answer += cur.val;
		}
		System.out.println(answer);
	}
}
