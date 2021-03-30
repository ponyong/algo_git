package Algo_Study_BOJ;

import java.io.*;

public class Main_5582_공통부분문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
