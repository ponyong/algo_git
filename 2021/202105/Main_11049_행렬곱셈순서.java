package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11049_행렬곱셈순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		int[][] minMap = new int[N + 1][N + 1];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			arr[i] = Integer.parseInt(str.nextToken());
			arr[i + 1] = Integer.parseInt(str.nextToken());
		}
		
		for(int l = 2; l <= N; l++) {
			
			for(int i = 1; i <= N - l + 1; i++) {
				
				int j = i + l - 1;
				minMap[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k < j; j++) {
					int cal = minMap[i][k] + minMap[k + 1][j] + arr[i-1] * arr[k] * arr[j];
					minMap[i][j] = Math.min(minMap[i][j], cal);
				}
			}
		}
		System.out.println(minMap[1][N]);
	}
}
