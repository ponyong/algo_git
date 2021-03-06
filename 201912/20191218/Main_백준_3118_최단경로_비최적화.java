package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_3118_최단경로_비최적화 {
	static int N, M;
	static Node adjList[];
	// weight의 의미 인접 비용
	static class Node {
		int v, weight;
		Node next;
		
		public Node(int v, int weight, Node next) {
			this.v = v;
			this.weight = weight;
			this.next = next;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		adjList = new Node[N+1];
		
		int from , to , w;
		
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			from = Integer.parseInt(str.nextToken());
			to = Integer.parseInt(str.nextToken());
			w = Integer.parseInt(str.nextToken());
			
			adjList[from] = new Node(to, w , adjList[from]);
		}
		
		System.out.println(go());
	}
	private static int go() {
		
		int[] D = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		
		int cur = 0;
		int min = 0;
		
		Node temp;
		
		while(true) {
			
			//1.미 방문 정점 중 최소비용 정점 찾기
			min = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && D[i] < min) {
					min = D[i];
					cur = i;
				}
			}
			if(cur == N ) return min; // 도착점이면 그때의 최소비용 리턴
			
			visited[cur] = true;
			
			//2. cur를 경유지로 하여 미방문정점까지의 최소비용 갱신
			
			temp = adjList[cur];
			while(temp != null) {
				if(!visited[temp.v] && D[temp.v] > min + temp.weight) {
					D[temp.v] = min + temp.weight;
				}
				temp = temp.next;
			}
		}
	}
}
