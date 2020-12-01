package ssafy;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기 {
	static int map[][];
	static int h,w,cnt,state;
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		for (int y = 0; y < h; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < w; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 1;
		map[r][c]=2;
		// 상 우 하 좌 +2 % 4
		
		solve(r,c,dir);
		System.out.println(cnt);
	}
	static void solve(int r,int c,int dir) {
		
		int ndir = (dir + 3) % 4;

		int nr = r + dy[ndir];
		int nc = c + dx[ndir];
		
		// a
		if (nr >= 0 && nc >= 0 && nr < h && nc < w && map[nr][nc] == 0) {
			r = nr;
			c = nc;
			dir = ndir;
			map[r][c] = 2;
			cnt++;
			state = 0;
			solve(r,c,dir);
		} else {// b
			if (state < 4) {
				state++;// 여기 없어
				dir = ndir;
				solve(r,c,dir);
			}else { //c
				int hdir = (dir + 2) % 4;
				int hr = r + dy[hdir];
				int hc = c + dx[hdir];
				if (hr >= 0 && hc >= 0 && hr < h && hc < w && map[hr][hc] != 1) {
					r = hr;
					c = hc;
					state=0;
					solve(r,c,dir);
				} else {//d
					return;
				}
			}
		}
	}
}
