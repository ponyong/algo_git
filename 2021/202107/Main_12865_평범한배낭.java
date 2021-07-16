package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		
		int[][] bag = new int[N + 1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			str = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(str.nextToken());
			value[i] = Integer.parseInt(str.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				
				if(j - weight[i] >= 0) {
					bag[i][j] = Math.max(bag[i - 1][j], bag[i - 1][j - weight[i]] + value[i]);
				}
				else {
					bag[i][j] = bag[i - 1][j];
				}
			}
		}
		System.out.println(bag[N][K]);
	}
}
