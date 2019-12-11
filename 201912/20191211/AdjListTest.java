package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


//5
//0 2 10
//1 3 5
//2 4 7
//0 4 3
//3 4 10
public class AdjListTest {
	static int N = 5;
	static Node[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine()); // 간선 수
		
		adjList = new Node[N];
		visited = new boolean[N];
		
		StringTokenizer str = null;
		int from, to , weight;
		for (int i = 0; i < M; ++i) {
			str = new StringTokenizer(br.readLine());
			from = Integer.parseInt(str.nextToken());
			to = Integer.parseInt(str.nextToken());
			weight = Integer.parseInt(str.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		System.out.println("adjList 생성");
//		dfs(0);
		bfs(0);
	}
	// 현재 탐색 정점 기준으로 인접한 정점 방문 : 너비 우선 탐색
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			
			Node temp = adjList[current];
			while(temp != null) {
				if(!visited[temp.vertex]) {
					visited[temp.vertex] = true;
					queue.add(temp.vertex);
				}
				temp = temp.next;
			}
		}
		
	}
	// 현재 탐색 정점 기준으로 인접한 정점 방문 : 깊이 우선
	private static void dfs(int current) {
		visited[current] = true;
		System.out.println(current);
		
		Node temp = adjList[current];
		
		while(temp != null) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
			temp = temp.next;
		}
	}
}
