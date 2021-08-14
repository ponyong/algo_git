package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_10026_적록색약 {
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[][] confuse_map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				int tmp = s.charAt(j) - '0';
				if (tmp == 'G' - '0') {
					map[i][j] = 'G' - '0';
					confuse_map[i][j] = 'R' - '0';
				} else {
					map[i][j] = tmp;
					confuse_map[i][j] = tmp;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		int cnt = 0;
		int confuse_cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					cnt++;
					visit[i][j] = true;
					queue.add(new int[] { i, j, map[i][j] });

					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();

						for (int k = 0; k < 4; k++) {
							int ni = tmp[0] + dx[k];
							int nj = tmp[1] + dy[k];

							if (ni >= 0 && nj >= 0 && ni < N && nj < N && !visit[ni][nj] && map[ni][nj] == tmp[2]) {
								visit[ni][nj] = true;
								queue.add(new int[] { ni, nj, tmp[2] });
							}
						}
					}
				}
			}
		}
		visit = new boolean[N][N];
		queue.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					confuse_cnt++;
					visit[i][j] = true;
					queue.add(new int[] { i, j, confuse_map[i][j] });

					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();

						for (int k = 0; k < 4; k++) {
							int ni = tmp[0] + dx[k];
							int nj = tmp[1] + dy[k];

							if (ni >= 0 && nj >= 0 && ni < N && nj < N && !visit[ni][nj]
									&& confuse_map[ni][nj] == tmp[2]) {
								visit[ni][nj] = true;
								queue.add(new int[] { ni, nj, tmp[2] });
							}
						}
					}
				}
			}
		}

		System.out.println(cnt + " " + confuse_cnt);
	}
}
