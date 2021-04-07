package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1328_고층빌딩 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int L = Integer.parseInt(str.nextToken());
		int R = Integer.parseInt(str.nextToken());
		
		long[][][] dp = new long[101][101][101];
		
		dp[1][1][1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i][i][1] = dp[i][1][i] = 1;
			
			for(int l = 1; l <= L; l++) {
				for(int r = 1; r <= R; r++) {
					
					if(dp[i][l][r] != 0) {
						continue;
					}
					dp[i][l][r] += dp[i - 1][l][r] * (i - 2);
					dp[i][l][r] += dp[i - 1][l - 1][r];
					dp[i][l][r] += dp[i - 1][l][r - 1];
					dp[i][l][r] %= 1000000007;
				}
			}
		}
		System.out.println(dp[N][L][R]);
	}
}
