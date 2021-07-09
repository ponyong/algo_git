package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17182_우주탐사선 {
	static int[][] map;
	static boolean[] visit;
	static int N;
	static int result;
	private static void dfs(int start, int sum, int cnt) {
		
		if(cnt == N) {
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, sum + map[start][i], cnt + 1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N];
		result = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		// 최단 거리 구하기 
		
		for(int root = 0; root < N; root++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][root] + map[root][j]);
				}
			}
		}
		
		visit[K] = true;
		dfs(K,0,1);
		System.out.println(result);
	}
}
