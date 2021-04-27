package Algo_Study_BOJ;

import java.io.*;
import java.util.*;
import java.awt.*;

class Land {
	int r;
	int c;
	int cost;

	public Land(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
}

public class Main_2146_다리만들기 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int landNum = 2;
	static int min = Integer.MAX_VALUE;
	private static void make(int r, int c) {
		Queue<Land> queue = new LinkedList<Land>();
		queue.add(new Land(r, c, 0));
		visit[r][c] = true;

		map[r][c] = landNum;

		while (!queue.isEmpty()) {
			Land cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc] == 1) {
					visit[nr][nc] = true;
					map[nr][nc] = landNum;
					queue.add(new Land(nr, nc, 0));
				}
			}
		}
		landNum++;
	}
	
	private static void bfs(int r, int c) {
		Queue<Land> queue = new LinkedList<Land>();
		queue.add(new Land(r, c, 0));
		
		int curNum = map[r][c];
		visit[r][c] = true;
		
		while(!queue.isEmpty()) {
			Land cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc] != curNum) {
					visit[nr][nc] = true;
					
					if(map[nr][nc] == 0) {
						queue.add(new Land(nr, nc, cur.cost + 1));
					}
					else {
						min = Math.min(min, cur.cost);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];
		StringTokenizer str;
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					make(i, j);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] >= 2) {
					visit = new boolean[N][N];
					bfs(i,j);
				}
			}
		}
		System.out.println(min);
	}
}
