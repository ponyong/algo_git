package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { -1, 0, 1, 0 };
	static int[] cnt = new int[] { 1, 1, 2, 2 };

	static int[][] sx = new int[][] { { -1, 1, -2, -1, 1, 2, -1, 1, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2 },
			{ 1, -1, 2, 1, -1, -2, 1, -1, 0 }, { 1, 1, 0, 0, 0, 0, -1, -1, -2 } };
	static int[][] sy = new int[][] { { 1, 1, 0, 0, 0, 0, -1, -1, -2 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0 }, // y방향
			{ -1, -1, 0, 0, 0, 0, 1, 1, 2 }, { 1, -1, 2, 1, -1, -2, 1, -1, 0 } };

	static int[] ratio = new int[] { 1, 1, 2, 7, 7, 2, 10, 10, 5 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		int answer = cal(N / 2, N / 2);
		System.out.println(answer);
	}

	private static int cal(int r, int c) {
		int result = 0;

		int curX = r;
		int curY = c;

		while (true) {
			for (int i = 0; i < 4; i++) {
				for (int d = 0; d < cnt[i]; d++) {

					int nextX = curX + dx[i];
					int nextY = curY + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
						return result;
					}

					int sand = map[nextX][nextY];
					map[nextX][nextY] = 0;
					int totalSpread = 0;

					for (int s = 0; s < 9; s++) {
						int sandX = nextX + sx[i][s];
						int sandY = nextY + sy[i][s];
						int curSpread = (sand * ratio[s]) / 100;

						if (sandX >= 0 && sandY >= 0 && sandX < N && sandY < N) {
							map[sandX][sandY] += curSpread;
						} else {
							result += curSpread;
						}

						totalSpread += curSpread;
					}

					int alphaX = nextX + dx[i];
					int alphaY = nextY + dy[i];

					int alphaSpread = sand - totalSpread;

					if (alphaX >= 0 && alphaY >= 0 && alphaX < N && alphaY < N) {
						map[alphaX][alphaY] += alphaSpread;
					} else {
						result += alphaSpread;
					}

					curX = nextX;
					curY = nextY;
				}
			}
			for (int k = 0; k < 4; k++) {
				cnt[k] += 2;
			}
		}
	}
}
