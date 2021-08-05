package Algo_Study_BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 *  4 4 1
 *  10 80 20 10
 *  1 2 50
 *  1 3 70
 *  2 4 50
 *  3 4 70
 *  1 4
 *  
 *  answer : 160
 */

public class Main_1602_도망자원숭이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int Q = Integer.parseInt(str.nextToken());
		final int INF = 987654321;
		
		int[][] dp = new int[N + 1][N + 1];
		int[][] answer = new int[N + 1][N + 1]; 
		int[] dog = new int[N + 1];
		Integer[] dogIdx = new Integer[N + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					dp[i][j] = 0;
					answer[i][j] = dog[i];
					continue;
				}
				dp[i][j] = INF;
				answer[i][j] = INF;
			}
		}
		 
		str = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			dog[i] = Integer.parseInt(str.nextToken());
			dogIdx[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());
			
			dp[st][ed] = cost;
			dp[ed][st] = cost;
			
			answer[st][ed] = cost + Math.max(dog[st], dog[ed]);
			answer[ed][st] = cost + Math.max(dog[ed], dog[st]);
		}

        Arrays.sort(dogIdx, 1, N + 1, new Comparator<Integer>() {
        	 
            @Override
            public int compare(Integer o1, Integer o2) {
                return dog[o1] - dog[o2];
            }
 
        });
		for(int k = 1; k <= N; k++) {
			
			int idx = dogIdx[k];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][idx] + dp[idx][j]);
					answer[i][j] = Math.min(answer[i][j], dp[i][j] + Math.max(dog[i], Math.max(dog[idx], dog[j]))); 	
				}
			}
			
		}
		for(int i = 0; i < Q; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			if(answer[st][ed] == INF) {
				System.out.println(-1);
				continue;
			}
			System.out.println(answer[st][ed]);
		}
	}
}
