package Algo_Study_BOJ;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Spot {

	int r;
	int c;

	int cnt;

	public Spot(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main_1261_알고스팟 {
	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());

		int[][] map = new int[N + 1][M + 1];
		boolean[][] visit = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = tmp.charAt(j - 1) - '0';
			}
		}
		PriorityQueue<Spot> pq = new PriorityQueue<Spot>(new Comparator<Spot>() {

			@Override
			public int compare(Spot o1, Spot o2) {
				return o1.cnt - o2.cnt;
			}
		});

		pq.add(new Spot(1, 1, 0));
		visit[1][1] = true;

		while (!pq.isEmpty()) {
			Spot cur = pq.poll();

			if(cur.r == N && cur.c == M) {
				System.out.println(cur.cnt);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				
				if(nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
					
					if(!visit[nr][nc] && map[nr][nc] == 0) {
						visit[nr][nc] = true;
						pq.add(new Spot(nr, nc, cur.cnt));
 					}
					
					if(!visit[nr][nc] && map[nr][nc] == 1) {
						visit[nr][nc] = true;
						pq.add(new Spot(nr, nc, cur.cnt + 1));
					}
				}
			}
 		}
	}
}
