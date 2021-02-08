package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Main_백준_15683_감시 {
	static ArrayList<int[]> list;
	static int result;
	static int[] dx = { -1, 0, 1, 0 }; // 우 하 좌 상
	static int[] dy = { 0, 1, 0, -1 };
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		int[][] map = new int[N][M];
		visit = new boolean[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int t = Integer.parseInt(temp.nextToken());
				// 0과 6이 아니면서 (감시탑이면) list에 저장
				if (t != 0 && t != 6) {
					map[i][j] = t;
					list.add(new int[] { i, j, t });
				} else {
					map[i][j] = t;
				}

			}
		}
		result = Integer.MAX_VALUE;
		dfs(map, N, M, 0);
		System.out.println(result);
	}

	private static void dfs(int[][] map, int N, int M, int num) {

		if (num == list.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 && !visit[i][j]) {
						cnt++;
					}
				}
			}
			result = result > cnt ? cnt : result;
			return;
		}
		int[] temp = list.get(num);
		int x = temp[0];
		int y = temp[1];
		int t = temp[2];

		switch (t) {
		case 1:
			for (int i = 0; i < 4; i++) {
				int ni = x + dx[i];
				int nj = y + dy[i];

				Queue<int[]> queue = new LinkedList<>();
				while (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 6) {
					if (map[ni][nj] == 0 && !visit[ni][nj]) {
						visit[ni][nj] = true;
						queue.add(new int[] { ni, nj });
					}
					ni += dx[i];
					nj += dy[i];
				}
				dfs(map, N, M, num + 1);
				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					visit[poll[0]][poll[1]] = false;
				}
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				Queue<int[]> queue = new LinkedList<>();
				for (int j = 0; j < 2; j++) {
					int val = i + 2 * j;
					int ni = x + dx[val];
					int nj = y + dy[val];

					while (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 6) {
						if (map[ni][nj] == 0 && !visit[ni][nj]) {
							visit[ni][nj] = true;
							queue.add(new int[] { ni, nj });
						}
						ni += dx[val];
						nj += dy[val];
					}
				}
				dfs(map, N, M, num + 1);
				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					visit[poll[0]][poll[1]] = false;
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				Queue<int[]> queue = new LinkedList<>();
				for (int j = 0; j < 2; j++) {
					int val = i + j;
					if (i + j == 4)
						val = 0;
					int ni = x + dx[val];
					int nj = y + dy[val];

					while (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 6) {
						if (map[ni][nj] == 0 && !visit[ni][nj]) {
							visit[ni][nj] = true;
							queue.add(new int[] { ni, nj });
						}
						ni += dx[val];
						nj += dy[val];
					}
				}
				dfs(map, N, M, num + 1);
				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					visit[poll[0]][poll[1]] = false;
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				Queue<int[]> queue = new LinkedList<>();
				for (int j = -1; j <= 1; j++) {
					int val = i + j;
					if (val < 0)
						val = 3;
					if (val == 4)
						val = 0;
					int ni = x + dx[val];
					int nj = y + dy[val];

					while (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 6) {
						if (map[ni][nj] == 0 && !visit[ni][nj]) {
							visit[ni][nj] = true;
							queue.add(new int[] { ni, nj });
						}
						ni += dx[val];
						nj += dy[val];
					}
				}
				dfs(map, N, M, num + 1);
				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					visit[poll[0]][poll[1]] = false;
				}
			}
			break;
		case 5:
			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < 4; i++) {
				int ni = x + dx[i];
				int nj = y + dy[i];

				while (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 6) {
					if (map[ni][nj] == 0 && !visit[ni][nj]) {
						visit[ni][nj] = true;
						queue.add(new int[] { ni, nj });
					}
					ni += dx[i];
					nj += dy[i];
				}
			}
			dfs(map, N, M, num + 1);
			while (!queue.isEmpty()) {
				int[] poll = queue.poll();
				visit[poll[0]][poll[1]] = false;
			}
			break;
		}

	}
}
