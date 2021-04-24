package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1240_노드사이의거리 {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[][] dist = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = INF;
				}
			}
		}
		for(int i = 0; i < N - 1; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			int cost = Integer.parseInt(str.nextToken());
			
			dist[st][ed] = cost;
			dist[ed][st] = cost;
		}
		
		for(int k = 1; k <= N; k++) {
			
			for(int i = 1; i <= N; i++) {
				
				for(int j = 1; j <= N; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			System.out.println(dist[st][ed]);
		}
	}
}
