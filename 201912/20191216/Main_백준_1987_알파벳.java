package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_서울8반_권혁진 {
	static int[] dx = new int[] { 1, -1, 0 , 0 };
	static int[] dy = new int[] { 0,  0, 1 ,-1 };
	static int N, M;
	static boolean[] visit;
	static char[][] map;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new char[N][M];
		visit = new boolean[26]; // A~Z 체크 배열
		
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		visit[map[0][0] - 'A'] = true; // (0,0) 좌표 true
		dfs(0,0,1); // 시작 좌표, 시작 길이
		System.out.println(max);
		
		
	}

	private static void dfs(int x, int y, int num) {
		
		max = num > max ? num : max;
		for(int i = 0; i < 4; i++) {
			int ni = x + dx[i];
			int nj = y + dy[i];
			
			if(ni >= 0 && nj >= 0 && ni < N && nj < M && !visit[map[ni][nj] - 'A']) {
				visit[map[ni][nj] - 'A'] = true;
				dfs(ni, nj, num + 1);
				visit[map[ni][nj] - 'A'] = false;
			}
		}
	}
}
