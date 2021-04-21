package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1956_운동 {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(str.nextToken());
		int E = Integer.parseInt(str.nextToken());
		
		int[][] map = new int[V + 1][V + 1];
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				map[i][j] = INF;
			}
		}
		for(int i = 0; i < E; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			
			map[st][ed] = cost;
		}
		
		for(int k = 1; k <= V; k++) {
			
			for(int i = 1; i <= V; i++) {
				
				for(int j = 1; j <= V; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		int result = INF;
		for(int i = 1; i <= V; i++) {
			
			for(int j = 1; j <= V; j++) {
				
				if(i == j) {
					continue;
				}
				if(map[i][j] != INF && map[j][i] != INF) {
					result = Math.min(result, map[i][j] + map[j][i]);
				}
			}
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
}
