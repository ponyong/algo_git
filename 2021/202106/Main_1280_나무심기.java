package Algo_Study_BOJ;

import java.io.*;

public class Main_1280_나무심기 {
	static int N;
	static long[] sum, cnt;
	static final int MAX = 200002;
	static final int MOD = 1000000007;
	
	static void Update(int idx, int val, long[] arr) {
		
		for(int i = idx; i <= MAX; i += (i & -i)) {
			arr[i] += val;
		}
	}
	
	static long sum(int idx, long[] arr) {
		
		long result = 0;
		
		for(int i = idx; i > 0; i -= (i & - i)) {
			result += arr[i];
		}
		
		return result; 
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		sum = new long[MAX + 1];
		cnt = new long[MAX + 1];
		
		int tree;
		long answer = 1;
		
		for(int i = 0; i < N; i++) {
			tree = Integer.parseInt(br.readLine());
			tree++;
			
			if(i != 0) {
				// (작은 나무의 개수) * (현재 좌표) - (작은 나무의 좌표값의 "합")
				long left = ((sum(tree - 1, cnt) * tree) - sum(tree - 1, sum)) % MOD;
				
				// (큰 나무의 좌표값의 "합" - (큰 나무의 개수) * ( 현재 좌표 )
				long right = (sum(MAX - 1, sum) - sum(tree, sum) - ((sum(MAX - 1, cnt) - sum(tree, cnt)) * tree)) % MOD;
				
				answer =  (answer * (left + right)) % MOD;
			}
			
			Update(tree, 1, cnt);
			Update(tree, tree, sum);
		}
		System.out.println(answer);
	}
}