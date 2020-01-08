package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_1916_최소비용구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 도시 개수
		int M = Integer.parseInt(br.readLine()); // 버스 개수

//      List[] list = new ArrayList[N];
		int[] dist = new int[N + 1];

		int[][] map = new int[N + 1][N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE / 2);
		boolean[] check = new boolean[N + 1];
//      for(int i = 0; i < N; i++) {
//         list[i] = new ArrayList<int[]>();
//      }
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = -1;
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			int distance = Integer.parseInt(str.nextToken());
			if (map[start][end] == -1 || distance < map[start][end]) {
				map[start][end] = distance;
			}
		}
		StringTokenizer tmp = new StringTokenizer(br.readLine());
		int s_point = Integer.parseInt(tmp.nextToken());
		int e_point = Integer.parseInt(tmp.nextToken());
		// 시작 값 갱신
		dist[s_point] = 0;

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE / 2;
			int min_index = -1;

			// 쵝소값 찾기

			for (int j = 1; j < N + 1; j++) {
				if (!check[j] && dist[j] != Integer.MAX_VALUE / 2) {
					if (dist[j] < min) {
						min = dist[j];
						min_index = j;
					}
				}
			}
			if (min_index == -1)
				break;
			check[min_index] = true;

			for (int j = 1; j < N + 1; j++) {
				if (!check[j] && map[min_index][j] != -1) {
					if (dist[j] > dist[min_index] + map[min_index][j]) {
						dist[j] = dist[min_index] + map[min_index][j];
					}
				}
			}
		}
		System.out.println(dist[e_point]);
	}
}