package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int N, cnt;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[j][i] = Integer.parseInt(str.nextToken());
			}
		}
		// 가로면 0 대각선은 1 세로는 2
		
		Queue<int[]> queue = new LinkedList<>();
		
		cnt = 0; // 경우의 수 세는 방법
		
		dfs(1,0,0);
		
		System.out.println(cnt);
	}

	private static void dfs(int i, int j, int k) {
		int x = i; // 1
		int y = j; // 0
		int role = k;
		if(i == N-1 && j == N-1) {
			cnt++;
			return;
		}
		
		// 가로로 왔으면
		if(role == 0) {
			
			int nx = x + 1;
			int ny = y + 1;
			if( nx < N && map[nx][y] == 0) {
				dfs(nx, y , 0);
			}
			
			if( nx < N && ny < N && map[nx][y] == 0 && map[nx][ny] == 0 && map[x][ny] == 0) {
				dfs(nx, ny , 1);
			}
		} 

		//대각선으로 왔으면
		else if(role == 1) {
			int nx = x + 1;
			int ny = y + 1;
			
			if( nx < N && map[nx][y] == 0) {
				dfs(nx, y, 0);
			}
			
			if ( ny < N && map[x][ny] == 0) {
				dfs(x , ny , 2);
			}
			
			if( nx < N && ny < N && map[nx][y] == 0 && map[nx][ny] == 0 && map[x][ny] == 0) {
				dfs(nx, ny , 1);
			}
		}
		
		// 세로로 왔으면 
		else {
			
			int nx = x + 1;
			int ny = y + 1;
			
			
			if ( ny < N && map[x][ny] == 0) {
				dfs(x, ny, 2);
			}
			if( nx < N && ny < N && map[nx][y] == 0 && map[nx][ny] == 0 && map[x][ny] == 0) {
				dfs(nx , ny, 1);
			}
		}
		
	}
}
