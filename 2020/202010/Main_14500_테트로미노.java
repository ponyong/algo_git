package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	
	static int[][] map;
	static boolean[][] check;
	static int N, M;
	static int result;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1,  0, -1 };
	private static void dfs(int x, int y, int sum, int len) {
		if(len >= 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
			
			if(!check[nx][ny]) {
				check[nx][ny] = true;
				
				dfs(nx, ny, sum + map[nx][ny], len + 1);
				
				check[nx][ny] = false;
			}
		}
	}
	private static void check_t(int x, int y) {
		int sum = 0;
		
		// ㅏ 
		if(x + 1 <= N && y - 1 >= 1 && y + 1 <= M ) {
			sum = map[x][y] + map[x + 1][y] + map[x][y-1] + map[x][y+1];
			result = Math.max(result, sum);
		}
		// ㅜ 
		if(x + 1 <= N && y + 1 <= M && x - 1 >= 1) {
			sum = map[x][y] + map[x+1][y] + map[x][y+1] + map[x-1][y];
			result = Math.max(result, sum);
		}
		
		// ㅓ
		if(x - 1 >= 1 && y + 1 <= M && y - 1 >= 1) {
			sum = map[x][y] + map[x-1][y] + map[x][y+1] + map[x][y-1];
			result = Math.max(result, sum);
		}
		
		// ㅗ
		if(x - 1 >= 1 && x + 1 <= N && y - 1 >= 1) {
			sum = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1];
			result = Math.max(result, sum);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken()); // N
		M = Integer.parseInt(str.nextToken()); // M
		
		map = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];
		result = 0;
		for(int i = 1; i <= N; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(tmp.nextToken());
				check[i][j] = false;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				check[i][j] = true;
				dfs(i, j, map[i][j] , 1);
				check[i][j] = false;
				check_t(i, j);
			}
		}
		System.out.println(result);
	}
}
