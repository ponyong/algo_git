package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1507_궁금한민호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N + 1][N + 1];
		int[][] nextMap = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = nextMap[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {

					if(i == j || j == k || k == i) {
						continue;
					}
					
					if(map[i][j] > map[i][k] + map[k][j]) {
						System.out.println(-1);
						return;
					}
					
					if(map[i][j] == map[i][k] + map[k][j]) {
						nextMap[i][j] = 987654321;
					}
				}
			}
		}
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= N; j++) {
				
				if(i >= j && nextMap[i][j] != 987654321) {
					answer += nextMap[i][j];
				}
			}
		}
		System.out.println(answer);
	}
}
