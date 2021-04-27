package Algo_Study_BOJ;

import java.io.*;

public class Main_1248_맞춰봐 {
	static int N;
	static int[] arr;
	static char[][] map;
	private static boolean isOk(int idx) {
		int sum = 0;
		
		for(int i = idx; i >= 0; i--) {
			sum += arr[i];
			
			if(map[i][idx] == '+' && sum <= 0) {
				return false;
			}
			if(map[i][idx] == '0' && sum != 0) {
				return false;
			}
			if(map[i][idx] == '-' && sum >= 0) {
				return false;
			}
		}
		return true;
	}
	private static void dfs(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.exit(0);
		}
		
		for(int i = -10; i <= 10; i++) {
			arr[idx] = i;
			
			if(isOk(idx)) {
				dfs(idx + 1);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		map = new char[N][N];
		
		String op = br.readLine();
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				map[i][j] = op.charAt(idx++);
			}
		}
		dfs(0);
	}

}	
