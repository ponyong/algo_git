package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1012_유기농배추 {
	
	public static int[] dx = { 0, 0, 1, -1};
	public static int[] dy = { 1, -1, 0, 0};
	public static void dfs(int x, int y , int[][] map , boolean[][] visit) {
		visit[x][y] = true; // 들어온 위치 방문 체크 
		
		// 4방 탐색을 하면서 방문하지 않은 1이 근거리에 있다면 dfs 들어감
		for(int i = 0; i < 4; i++) {
			int ni = x + dx[i];
			int nj = y + dy[i];
			
			// 만약 map 의 범위를 넘지 않고, 조건에 맞는다면 탐색
			if(ni >= 0 && nj >= 0 && ni < map.length && nj < map[0].length && map[ni][nj] == 1 && !visit[ni][nj]) {
				dfs(ni, nj , map, visit);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(str.nextToken()); // 가로
			int N = Integer.parseInt(str.nextToken()); // 세로
			int K = Integer.parseInt(str.nextToken()); // 배추 개수
			
			int[][] map = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(temp.nextToken());
				int y = Integer.parseInt(temp.nextToken());
				map[y][x] = 1;
			}
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j, map, visit);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
