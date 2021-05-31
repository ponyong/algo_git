package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
	static final int INF = 987654321;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] dp;
	static int N;
	private static int dfs(int r, int c) {
		
		if(dp[r][c] != INF) {
			return dp[r][c];
		}
		else {
			
			dp[r][c] = 1;
			int len = 0;
			for(int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > map[r][c]) {
					len = Math.max(dfs(nr, nc), len);
				}
			}
			dp[r][c] += len;
		}
		return dp[r][c];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];
		StringTokenizer str;

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				dp[i][j] = INF;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = Math.max(dfs(i, j), cnt);
			}
		}
		System.out.println(cnt);
	}
}
