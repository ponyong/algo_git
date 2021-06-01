package Algo_Study_BOJ;

import java.util.*;
import java.io.*;

public class Main_2533_사회망서비스SNS {
	static List<List<Integer>> list;
	static boolean[] visit;
	static int[][] dp;
	static int N;
	private static void dfs(int idx) {

		visit[idx] = true;
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		
		for(int next : list.get(idx)) {
			if(visit[next]) {
				continue;
			}
			dfs(next);
			
			dp[idx][0] += dp[next][1];
			dp[idx][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		dp = new int[N + 1][2];
		list = new ArrayList<List<Integer>>();
		for(int i = 1; i <= N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		StringTokenizer str;	
		for(int i = 0; i < N - 1; i++) {
			str = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(str.nextToken());
			int child = Integer.parseInt(str.nextToken());
			
			list.get(parent).add(child);
			list.get(child).add(parent);
		}
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
}
