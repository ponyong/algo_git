package Algo_Study_BOJ;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20005_보스몬스터 {
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		int P = Integer.parseInt(str.nextToken());

		char[][] map = new char[M][N];
		boolean[][] visit = new boolean[M][N];

		int[] damage = new int[P];
		boolean[] possible = new boolean[P];

		int bossR = 0;
		int bossC = 0;
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);

				if (map[i][j] == 'B') {
					bossR = i;
					bossC = j;
				}
			}
		}

		for (int i = 0; i < P; i++) {
			str = new StringTokenizer(br.readLine());

			char user = str.nextToken().charAt(0);
			int val = Integer.parseInt(str.nextToken());

			damage[user - 'a'] = val;
		}

		int bossHp = Integer.parseInt(br.readLine());

		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(bossR, bossC));
		visit[bossR][bossC] = true;

		int result = 0;
		while (bossHp > 0) {

			int size = queue.size();

			while (size-- > 0) {

				Point cur = queue.poll();

				if (isUser(cur.x, cur.y, map)) {
					possible[map[cur.x][cur.y] - 'a'] = true;
					result++;
				}

				for (int i = 0; i < 4; i++) {
					int nr = cur.x + dx[i];
					int nc = cur.y + dy[i];
					
					if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc] != 'X') {
						visit[nr][nc] = true;
						queue.add(new Point(nr, nc));
					}
				}
			}
			for(int i = 0; i < P; i++) {
				if(possible[i]) {
					bossHp -= damage[i];
				}
			}
		}
		System.out.println(result);
	}

	private static boolean isUser(int r, int c, char[][] map) {
		if (map[r][c] >= 'a' && map[r][c] <= 'z') {
			return true;
		}
		return false;
	}
}
