package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Build implements Comparable<Build> {

	int l;
	int r;
	int c;
	int cnt;

	public Build(int l, int r, int c, int cnt) {
		this.l = l;
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Build o) {
		return this.cnt - o.cnt;
	}

}

public class Main_6593_상범빌딩 {
	static int[] dx = new int[] { 1, 0, -1, 0, 0, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1, 0, 0 };
	static int[] dl = new int[] { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str;

		while (true) {
			str = new StringTokenizer(br.readLine());
			PriorityQueue<Build> pq = new PriorityQueue<Build>();
			int L = Integer.parseInt(str.nextToken()); // 높이
			int R = Integer.parseInt(str.nextToken()); // 행
			int C = Integer.parseInt(str.nextToken()); // 렬

			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			int st_l = 0, st_r = 0, st_c = 0;
			int ed_l = 0, ed_r = 0, ed_c = 0;
			char[][][] map = new char[L][R][C];
			boolean[][][] visit = new boolean[L][R][C];
			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					String s = br.readLine();
					for (int j = 0; j < C; j++) {
						map[k][i][j] = s.charAt(j);

						if (map[k][i][j] == 'S') {
							st_l = k;
							st_r = i;
							st_c = j;
							visit[k][i][j] = true;
							pq.add(new Build(k, i, j, 0));
						} else if (map[k][i][j] == 'E') {
							ed_l = k;
							ed_r = i;
							ed_c = j;
						}
					}
				}
				String empty = br.readLine();
			}
			boolean flag = false;
			int result = 0;
			while (!pq.isEmpty()) {

				Build cur = pq.poll();
				if(cur.l == ed_l && cur.r == ed_r && cur.c == ed_c) {
					flag = true;
					result = cur.cnt;
					break;
				}
				for (int i = 0; i < 6; i++) {
					int nl = cur.l + dl[i];
					int nr = cur.r + dx[i];
					int nc = cur.c + dy[i];
					
					if(nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nl][nr][nc] && map[nl][nr][nc] != '#') {
						visit[nl][nr][nc] = true;
						pq.add(new Build(nl, nr, nc, cur.cnt + 1));
					}
				}
			}
			if(flag) {
				System.out.println("Escaped in " + result  + " minute(s).");
			}
			else {
				System.out.println("Trapped!");
			}
		}
	}
}
