package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_8012_한동이는영업사원 {
	
	static List<ArrayList<Integer>> list;
	static boolean[] visit;
	static int[] depth;
	static int[][] parent;
	static int N;
	private static void dfs(int num, int dep) {
		visit[num] = true;
		
		depth[num] = dep;
		
		for(int next : list.get(num)) {
			if(visit[next]) {
				continue;
			}
			parent[next][0] = num;
			dfs(next, dep + 1);
		}
	}
	
	private static void setParent() {
		for(int j = 1; j < 20; j++) {
			for(int i = 1; i <= N; i++) {
				parent[i][j] = parent[parent[i][j - 1]][j - 1];
			}
		}
	}
	
	private static int lca(int a, int b) {
		
		if(depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		for(int i = 19; i >= 0; i--) {
			if(depth[b] - depth[a] >= (1 << i)) {
				b = parent[b][i]; 
			}
		}
		if(a == b) {
			return a;
		}
		
		for(int i = 19; i >= 0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Integer>>();
		visit = new boolean[N + 1];
		depth = new int[N + 1];
		parent = new int[N + 1][20];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			list.get(st).add(ed);
			list.get(ed).add(st);
		}
		
		dfs(1, 0);
		setParent();
		
		int M = Integer.parseInt(br.readLine());
		
		int b = 1;
		int answer = 0;
		for(int i = 0; i < M; i++) {
			int a = Integer.parseInt(br.readLine());
			
			int find = lca(a, b);
			answer += depth[a] + depth[b] - 2 * depth[find];
			b = a;
		}
		System.out.println(answer);
	}
}
