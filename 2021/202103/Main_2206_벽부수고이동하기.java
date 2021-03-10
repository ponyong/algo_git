package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Node4 {

	int r;
	int c;
	int count;
	int isBreak;

	public Node4(int r, int c, int count, int isBreak) {

		this.r = r;
		this.c = c;
		this.count = count;
		this.isBreak = isBreak;
	}

}

public class Main_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static boolean[][][] visit;

	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	private static void bfs(int r, int c) {

		Queue<Node4> queue = new LinkedList<Node4>();

		queue.add(new Node4(r, c, 1, 0));

		visit[r][c][0] = true;
		visit[r][c][1] = true;

		while (!queue.isEmpty()) {
			Node4 cur = queue.poll();

			if (cur.r == N - 1 && cur.c == M - 1) {
				System.out.println(cur.count);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];

				if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1)
					continue;

				if (map[nr][nc] == 1) {
					if (cur.isBreak == 0 && !visit[nr][nc][1]) {
						visit[nr][nc][1] = true;
						queue.add(new Node4(nr, nc, cur.count + 1, 1));
					}
				} else {
					if (!visit[nr][nc][cur.isBreak]) {
						visit[nr][nc][cur.isBreak] = true;
						queue.add(new Node4(nr, nc, cur.count + 1, cur.isBreak));
					}
				}
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs(0, 0);
	}

}
