package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15684_사다리조작 {
	static int N, M, H;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static boolean tr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		H = Integer.parseInt(str.nextToken());

		map = new int[H + 2][N + 1];

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			map[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())] = 1;
		}

		for (int i = 0; i <= 3; i++) {
			max = i;
			solve(1, 1, 0);
			if (tr) {
				break;
			}
		}
		System.out.println(tr ? max : -1);
	}

	private static void solve(int x, int y, int cnt) {
		if (tr) {
			return;
		}

		if (max == cnt) {
			if (check()) {
				tr = true;
			}
			return;
		}
		
		for (int i = (y < N ? x : x + 1); i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 1 || map[i][j - 1] == 1 || map[i][j + 1] == 1)
					continue;
				map[i][j] = 1;
				solve(i, j, cnt + 1);
				map[i][j] = 0;
			}
		}
	}

	static boolean check() {
		for (int j = 1; j <= N; j++) {
			int i = 1;
			int temp = j;
			while (i <= H + 1) {

				if (map[i][temp] == 1) {
					temp++;
				} else if (map[i][temp - 1] == 1) {
					temp--;
				}
				i++;
			}
			if (j != temp) {
				return false;
			}
		}
		return true;
	}
}
