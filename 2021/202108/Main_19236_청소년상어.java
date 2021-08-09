package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

class Fish {
	int id;
	int r;
	int c;
	int dir;
	int life;

	public Fish(int id, int r, int c, int dir, int life) {
		this.id = id;
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.life = life;
	}
}

public class Main_19236_청소년상어 {
	static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map;
	static Fish[] fish;
	static int answer = Integer.MIN_VALUE;
	
	private static void dfs(int sr, int sc, int sdir, int point) {
		answer = Math.max(answer, point);
		
		int[][] tempMap = new int[4][4];
		Fish[] tempFish = new Fish[17];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		for(int i = 1; i <= 16; i++) {
			tempFish[i] = new Fish(fish[i].id, fish[i].r, fish[i].c, fish[i].dir, fish[i].life);			
		}
		
		move();
		
		for(int i = 1; i < 4; i++) {
			int nr = sr + dx[sdir] * i;
			int nc = sc + dy[sdir] * i;
			
			if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != 0) {
				int nFish = map[nr][nc];
				int ndir = fish[nFish].dir;
				
				map[sr][sc] = 0;
				map[nr][nc] = -1;
				fish[nFish].life = 0;
				
				dfs(nr, nc, ndir, point + nFish);
				
				fish[nFish].life = 1;
				map[sr][sc] = -1;
				map[nr][nc] = nFish;
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				map[i][j] = tempMap[i][j];
			}
		}
		
		for(int i = 1; i <= 16; i++) {
			fish[i] = new Fish(tempFish[i].id, tempFish[i].r, tempFish[i].c, tempFish[i].dir, tempFish[i].life);
		}
		
	}
	private static void move() {
		for(int i = 1; i <= 16; i++) {
			if(fish[i].life == 0) {
				continue;
			}
			
			int cnt = 0;
			int dir = fish[i].dir;
			int nr = 0;
			int nc = 0;
			
			while(cnt < 8) {
				dir %= 8;
				fish[i].dir = dir;
			
				nr = fish[i].r + dx[dir];
				nc = fish[i].c + dy[dir];
				
				if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != - 1) {
					if(map[nr][nc] == 0) {
						map[fish[i].r][fish[i].c] = 0;
						fish[i].r = nr;
						fish[i].c = nc;
						map[nr][nc] = i;
					}
					else {
						int tempFish = fish[map[nr][nc]].id;
						fish[tempFish].r = fish[i].r;
						fish[tempFish].c = fish[i].c;
						map[fish[tempFish].r][fish[tempFish].c] = tempFish;
						
						fish[i].r = nr;
						fish[i].c = nc;
						map[nr][nc] = i;
					}
					break;
				}
				else {
					dir++;
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str;
		map = new int[4][4];
		fish = new Fish[17];
		
		for(int i = 0; i < 4; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int id = Integer.parseInt(str.nextToken());
				int dir = Integer.parseInt(str.nextToken()) - 1;
				
				fish[id] = new Fish(id, i, j, dir, 1);
				map[i][j] = id;
			}
		}
		
		int sr = 0;
		int sc = 0;
		int sdir = fish[map[0][0]].dir;
		int point = map[0][0];
		fish[map[0][0]].life = 0;
		map[0][0] = -1;
		
		dfs(sr, sc, sdir, point);
		
		System.out.println(answer);
	}

}
