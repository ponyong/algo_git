package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1613_역사 {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		int[][] dp = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = INF;
			}
		}
			
		for(int i = 0; i < K; i++) {
			str = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(str.nextToken());
			int second = Integer.parseInt(str.nextToken());
			
			dp[first][second] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}
		
		str = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(str.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < S; i++) {
			
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			if(dp[st][ed] == INF && dp[ed][st] == INF) {
				sb.append(0).append("\n");
			}
			else if(dp[st][ed] == INF && dp[ed][st] != INF) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
