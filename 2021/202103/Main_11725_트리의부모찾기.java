package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main_11725_트리의부모찾기 {
	static List<ArrayList<Integer>> list;
	static int[] parent;
	static boolean[] visit;
	public static void dfs(int node) {
		
		visit[node] = true;
		for(int next : list.get(node)) {
			
			if(!visit[next]) {
				parent[next] = node;
				dfs(next);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		visit = new boolean[N + 1];
		
		list = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		StringTokenizer str;
		for(int i = 0; i < N - 1; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			list.get(st).add(ed);
			list.get(ed).add(st);
		}
		
		dfs(1);
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
}
