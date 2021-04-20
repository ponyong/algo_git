package Algo_Study_BOJ;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11066_파일합치기 {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			int K = Integer.parseInt(br.readLine());
			
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int[] val = new int[K + 1];
			int[] sum = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];
			for(int i = 1; i <= K; i++) {
				val[i] = Integer.parseInt(str.nextToken());
				sum[i] = sum[i - 1] + val[i];
			}
			for(int k = 1; k < K; k++) {
				
				for(int i = 1; i + k <= K; i++) {
					dp[i][i + k] = Integer.MAX_VALUE;
					
					for(int j = i; j < i + k; j++) {
						dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + sum[i + k] - sum[i - 1]);
					}
				}
			}
			System.out.println(dp[1][K]);
		}
	}
}
