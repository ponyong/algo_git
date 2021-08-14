package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기 {

	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { -1, 0, 1, 0 };
	static int[] back_dx = new int[] { 1,0,-1,0 };
	static int[] back_dy = new int[] { 0,-1,0,1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());

		int[][] map = new int[N][M];
		boolean[][] check = new boolean[N][M];
		str = new StringTokenizer(br.readLine()); // 로봇좌표

		int st_x = Integer.parseInt(str.nextToken());
		int st_y = Integer.parseInt(str.nextToken());
		int dir = Integer.parseInt(str.nextToken());

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		int cnt = 0; // 청소한곳

		while (true) {
			// 1. 현재 위치를 청소한다.
			check[st_x][st_y] = true;
			cnt++;
			
			boolean c = false;
			// 4방향 다 막혔나..?
			for(int i = 0; i < 4; i++) {
				if(check[st_x + dx[(dir + 3) % 4]][st_y + dy[(dir + 3) % 4]] == false && map[st_x + dx[(dir + 3) % 4]][st_y + dy[(dir + 3) % 4]] != 1) {
					c = true;
				}
			}
			
			if(c == false && map[st_x + back_dx[dir]][st_y + back_dy[dir]] != 1 ) {
				if(st_x + dx[2] <= 0 && st_x +dx[2] > N && st_y &&)
				break;
			}
			
			// 두번
			if(c == false) {
				if(dir == 0) {
					st_x = st_x + dx[2];
					st_y = st_y + dy[2];
				}
				else if(dir == 1) {
					st_x = st_x + dx[3];
					st_y = st_y + dy[3];
				}
				else if(dir == 2) {
					st_x = st_x + dx[0];
					st_y = st_y + dy[0];
				}
				else {
					st_x = st_x + dx[1];
					st_y = st_y + dy[1];
				}
				continue;
			}
			
			// 2. 현재 위치에서 현재 방향 기준으로 왼쪽 방향부터 차례대로 탐색
			// a. 왼쪽에 청소하지 않은 공간이  존재 한다면 
			if(check[st_x + dx[(dir + 3) % 4]][st_y + dy[(dir + 3) % 4]] == false && map[st_x + dx[(dir + 3) % 4]][st_y + dy[(dir + 3) % 4]] != 1) {
				
				// 그 방향으로 바꾸고 
				dir = (dir + 3) % 4;
				// 그 방향으로 한칸 전진 후
				st_x = st_x + dx[(dir)];
				st_y = st_y + dy[(dir)];
				
				// 1번부터 진행 한다.
				continue;
			}
			// 왼쪽공간에 청소할 곳이 없다면(true 거나 벽이라면) 그 방향으로 회전하고 2번으로
			else {
				dir = (dir + 3) % 4;
				continue;
			}
			
			
		}

	}
}
