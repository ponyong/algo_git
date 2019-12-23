package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수 {
	public static int[] dx = { -1 , -1, -1, 0 , 0 , 1, 1, 1 }; // 8방
	public static int[] dy = { -1 ,  0,  1, -1, 1 , -1 , 0 , 1 }; // 8방
	public static int[][] map;
	public static boolean[][] visit;
	public static int cnt = 0;
	public static int W;
	public static int H;
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int k = 0; k < 8; k++) {
		
			int ni = x + dx[k];
			int nj = y + dy[k];
		
			if(ni >= 0 && ni < H && nj >= 0 && nj < W && !visit[ni][nj] && map[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		//지도의 너비 w와 높이 h가 주어진다
		//h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
		//0이 두 개 주어진다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			W = Integer.parseInt(str.nextToken()); // 너비 
			H = Integer.parseInt(str.nextToken()); // 높이
			
			if(W == 0 && H == 0) {
				break;
			}
			map = new int[H][W]; 
			visit = new boolean[H][W];
			for(int i = 0; i < H; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
			cnt = 0;
		}
	}
}
