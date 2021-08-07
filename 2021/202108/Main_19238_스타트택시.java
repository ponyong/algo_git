package Algo_Study_BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19238_스타트택시 {
	static int N, M, gas;
	static int[][] map;
	static int[][][] userMap;
	static Map<Integer, Point> goal;
	static final int INF = 987654321;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	private static void make(int idx, int r, int c) {

		userMap[idx][r][c] = 0;

		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(r, c));

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.x + dx[i];
				int nc = cur.y + dy[i];

				if (nr >= 1 && nr < N + 1 && nc >= 1 && nc < N + 1
						&& userMap[idx][nr][nc] > userMap[idx][cur.x][cur.y] + 1 && map[nr][nc] != 1) {
					queue.add(new Point(nr, nc));
					userMap[idx][nr][nc] = userMap[idx][cur.x][cur.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		gas = Integer.parseInt(str.nextToken());

		map = new int[N + 1][N + 1];
		userMap = new int[M + 1][N + 1][N + 1];
		goal = new HashMap<>();
		boolean[] check = new boolean[N + 1];
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			str = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					userMap[i][j][k] = INF;
				}
			}
		}
		str = new StringTokenizer(br.readLine());

		int taxi_r = Integer.parseInt(str.nextToken());
		int taxi_c = Integer.parseInt(str.nextToken());

		for (int i = 1; i <= M; i++) {
			str = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int goal_r = Integer.parseInt(str.nextToken());
			int goal_c = Integer.parseInt(str.nextToken());

			make(i, r, c);
			goal.put(i, new Point(goal_r, goal_c));
		}
		int cnt = 0;
		while (cnt < M) {
			flag = false;
			int idx = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= M; i++) {
				if (userMap[i][taxi_r][taxi_c] < min && !check[i]) {
					min = Math.min(min, userMap[i][taxi_r][taxi_c]);
					idx = i;
				}
			}
			Point ed = goal.get(idx);
			if (userMap[idx][taxi_r][taxi_c] + userMap[idx][ed.x][ed.y] < gas) {
				gas -= (userMap[idx][taxi_r][taxi_c] + userMap[idx][ed.x][ed.y]);
				taxi_r = ed.x;
				taxi_c = ed.y;
				gas += (userMap[idx][ed.x][ed.y] * 2);

				check[idx] = true;
			} else {
				flag = true;
				break;
			}
			cnt++;
		}
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(gas);
		}
	}
}
