package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_20926_얼음미로 {
	static final int Rock = -1;
	static final int INF = 987654321;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static List<List<Integer>> route;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		int[][] map = new int[N][M];
		route = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < (N + 1) * (M + 1); i++) {
			route.add(new ArrayList<Integer>());
		}
		int stR = 0, stC = 0, exR = 0, exC = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {

				char c = s.charAt(j);
				if (c == 'T') {
					stR = i;
					stC = j;
					map[i][j] = 0;
				} else if (c == 'R') {
					map[i][j] = Rock;
				} else if (c == 'H') {
					map[i][j] = INF;
				} else if (c == 'E') {
					exR = i;
					exC = j;
					map[i][j] = 0;
				} else {
					map[i][j] = c - '0';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == stR || map[i][j] == INF || map[i][j] == -1) {
					continue;
				}

				for (int k = 0; k < 4; k++) {
					int r = i;
					int c = j;
					int sum = 0;
					
					while(r >= 0 && r < N && c >= 0 && c < M) {
						
					}
				}
			}
		}
	}
}
