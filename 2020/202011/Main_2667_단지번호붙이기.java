package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667_단지번호붙이기 {
	static int[] dx = { 0, 0, -1 , 1 };
	static int[] dy = { 1, -1, 0 , 0 };
	static int N;
	static int[][] map;
	static boolean[][] check;
	static int cnt;
	private static void dfs(int i, int j) {
		
		check[i][j] = true;
		for(int k = 0; k < 4; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			
			if(ni >= 0 && ni < N && nj >= 0 && nj < N && !check[ni][nj] && map[ni][nj] == 1) {
				cnt++;
				dfs(ni, nj);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
				check[i][j] = false;
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !check[i][j]) {
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
