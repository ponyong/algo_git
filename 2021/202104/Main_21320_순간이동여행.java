package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21320_순간이동여행 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		long[] dp = new long[N + 10];
		
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= N; i++) {
			if(i % 2 != 0) {
				dp[i] = (2 * dp[i - 1] + 1) % 1000000007;
			}
			else {
				dp[i] = (long) ((dp[i - 2] + power(i / 2 - 1)) % 1000000007);
			}
		}
		
		if(N % 2 != K % 2) {
			System.out.print(dp[N]);
		}
		else {
			System.out.print(dp[N] - 1);
		}
	}

	private static long power(int cnt) {
		long answer = 4;
		for(int i = 1; i < cnt; i++) {
			answer = (answer * 4) % 1000000007;
		}
		return answer;
	}
}
