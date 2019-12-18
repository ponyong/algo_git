package com.ssafy;

import java.util.*;
import java.io.*;
public class Main_백준_1854_K번째최단경로찾기 {
	static int N, M, K;
	static Node adjList[];
	static ArrayList[] list;
	// weight의 의미 나까지 오는 최적값
	static class Node implements Comparable<Node> {
		int v, weight;
		Node next;
		public Node(int v, int weight, Node next) {
			this.v = v;
			this.weight = weight;
			this.next = next;
		}
		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		
		adjList = new Node[N+1];
		int from , to , w;
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			from = Integer.parseInt(str.nextToken());
			to = Integer.parseInt(str.nextToken());
			w = Integer.parseInt(str.nextToken());
			
			adjList[from] = new Node(to, w , adjList[from]);
		}
		go();
		for(int i = 1; i <= N; i++) {
			if(list[i].size() > K - 1) {
				System.out.println(list[i].get(K - 1));
			}
			else {
				System.out.println("-1");
			}
		}
	}
	private static int go() {
		
		int[] D = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		queue.add(new Node(1,0));
		list[1].add(0);
		
		Node temp;
		Node cur;
		while(true) {
			
			//1.미 방문 정점 중 최소비용 정점 찾기
			cur = queue.poll();
			if(visited[cur.v]) continue;
			if(cur.v == N ) return cur.weight; // 도착점이면 그때의 최소비용 리턴
			
			visited[cur.v] = true;
			
			//2. cur를 경유지로 하여 미방문정점까지의 최소비용 갱신
			
			temp = adjList[cur.v];
			while(temp != null) {
				if(!visited[temp.v] && D[temp.v] > cur.weight + temp.weight) {
					D[temp.v] = cur.weight + temp.weight;
					queue.add(new Node(temp.v, D[temp.v]));
					list[temp.v].add(D[temp.v]);
				}
				if(visited[temp.v]){
					list[temp.v].add(cur.weight + temp.weight);
				}
				temp = temp.next;
			}
		}
	}
}
