package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class point {
	public point(int x, int y, int dept, boolean up, boolean right, boolean down, boolean left) {
		this.x = x;
		this.y = y;
		this.dept = dept;
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
	}

	int x;
	int y;
	int dept;
	boolean up;
	boolean right;
	boolean down;
	boolean left;
}

public class Solution_SWEA_모의_탈주범검거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim()); // Testcase;

		for (int tc = 1; tc <= T; tc++) {

			// 세로 크기 N, 가로 크기 M, 맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C, 그리고 탈출 후 소요된 시간 L
			StringTokenizer str = new StringTokenizer(br.readLine().trim());

			int N = Integer.parseInt(str.nextToken()); // 세로
			int M = Integer.parseInt(str.nextToken()); // 가로
			int R = Integer.parseInt(str.nextToken()); // 맨홀 행
			int C = Integer.parseInt(str.nextToken()); // 맨홀 열
			int L = Integer.parseInt(str.nextToken()); // 탈출 후 시간

			point[][] map = new point[N][M];

			for (int i = 0; i < N; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int t = Integer.parseInt(temp.nextToken());
					if (t == 0) {
						map[i][j] = new point(i, j, 1, false, false, false, false);
					} else if (t == 1) {
						map[i][j] = new point(i, j, 1, true, true, true, true);
					} else if (t == 2) {
						map[i][j] = new point(i, j, 1, true, false, true, false);
					} else if (t == 3) {
						map[i][j] = new point(i, j, 1, false, true, false, true);
					} else if (t == 4) {
						map[i][j] = new point(i, j, 1, true, true, false, false);
					} else if (t == 5) {
						map[i][j] = new point(i, j, 1, false, true, true, false);
					} else if (t == 6) {
						map[i][j] = new point(i, j, 1, false, false, true, true);
					} else if (t == 7) {
						map[i][j] = new point(i, j, 1, true, false, false, true);
					}
				}
			}
			Queue<point> queue = new LinkedList<point>();
			boolean[][] flag = new boolean[N][M]; // 플래그 함수
			queue.add(map[R][C]); // 도둑 최초 위치를 삽입
			flag[R][C] = true;
			while (queue.size() > 0 && queue.peek().dept < L) {
				point t = queue.poll();

				if (t.x - 1 >= 0 && t.up && map[t.x - 1][t.y].down && !flag[t.x - 1][t.y]) {
					map[t.x - 1][t.y].dept = map[t.x][t.y].dept + 1;
					queue.add(map[t.x - 1][t.y]);
					flag[t.x - 1][t.y] = true;
				}
				if (t.y - 1 >= 0 && t.left && map[t.x][t.y - 1].right && !flag[t.x][t.y - 1]) {
					map[t.x][t.y - 1].dept = map[t.x][t.y].dept + 1;
					queue.add(map[t.x][t.y - 1]);
					flag[t.x][t.y - 1] = true;
				}
				if (t.x + 1 < N && t.down && map[t.x + 1][t.y].up && !flag[t.x + 1][t.y]) {
					map[t.x + 1][t.y].dept = map[t.x][t.y].dept + 1;
					queue.add(map[t.x + 1][t.y]);
					flag[t.x + 1][t.y] = true;
				}
				if (t.y + 1 < M && t.right && map[t.x][t.y + 1].left && !flag[t.x][t.y + 1]) {
					map[t.x][t.y + 1].dept = map[t.x][t.y].dept + 1;
					queue.add(map[t.x][t.y + 1]);
					flag[t.x][t.y + 1] = true;

				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (flag[i][j]) {
						cnt++;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}