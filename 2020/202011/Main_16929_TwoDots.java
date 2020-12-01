package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929_TwoDots {
	static char[][] map;
	static boolean[][] check;
	static int N, M;
	static int[] dx = {1 , 0, -1 , 0 };
	static int[] dy = {0 , 1, 0 ,  -1 };
	static boolean ans;
	private static void dfs(int i, int j, int dir) {
		
		check[i][j] = true;
		for(int k = 0; k < 4; k++) {
			
			if(dir == k) continue;
			int ni = i + dx[k];
			int nj = j + dy[k];
			
			if (ni < 0 || nj < 0 || ni >= N || nj >= M)
				continue;
			if (map[ni][nj] != map[i][j])
				continue;
			if (check[ni][nj] && map[i][j] == map[ni][nj]) {
				ans = true;
			}
			if (check[ni][nj])
				continue;
			dfs(ni, nj, (k + 2) % 4);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new char[N][M];
		check = new boolean[N][M];
		ans = false;
		for(int i = 0; i < N; i++) {
			String t = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = t.charAt(j);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j]) {
					dfs(i,j,-1);
				}
				else {
					continue;
				}
			}
		}
		System.out.println(ans ? "Yes" : "No");
	}
}
