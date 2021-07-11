package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Robot {
	int r;
	int c;
	int dir;

	public Robot(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}

public class Main_2174_로봇시뮬레이션 {
	// 우 하 좌 상
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static Map<Integer, Robot> robotMap = new HashMap<Integer, Robot>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(str.nextToken());
		int C = Integer.parseInt(str.nextToken());
		
		int[][] map = new int[C + 1][R + 1];
		
		str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int num = 1;
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			char dir = str.nextToken().charAt(0);
			
			map[c][r] = num;
			
			switch (dir) {
			case 'E':
				robotMap.put(num++, new Robot(c, r, 0));
				break;
			case 'S':
				robotMap.put(num++, new Robot(c, r, 3));
				break;
			case 'W':
				robotMap.put(num++, new Robot(c, r, 2));
				break;
			case 'N':
				robotMap.put(num++, new Robot(c, r, 1));
				break;
			}
		}
	
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int robotNum = Integer.parseInt(str.nextToken());
			int order = str.nextToken().charAt(0) - 'A';
			int count = Integer.parseInt(str.nextToken());
			
			Robot cur = robotMap.get(robotNum);
			
			int cur_c = cur.c;
			int cur_r = cur.r;
			// L
			if(order == 11) {
				for(int j = 0; j < count; j++) {
					cur.dir = (cur.dir + 1) % 4;
				}
				robotMap.put(robotNum, new Robot(cur.c, cur.r, cur.dir));
			}
			// R
			if(order == 17) {
				for(int j = 0; j < count; j++) {
					cur.dir = - ((cur.dir + 1) % 4) + 4;
				}
				robotMap.put(robotNum, new Robot(cur.c, cur.r, cur.dir));
			}
			// F
			if(order == 5) {
				for(int j = 0; j < count; j++) {
					int nc = cur.c + dy[cur.dir];
					int nr = cur.r + dx[cur.dir];
					
					if(nr >= 1 && nc >= 1 && nr <= C && nc <= R) {
						
						if(map[nc][nr] != 0) {
							System.out.println("Robot " + robotNum + " crashes into robot " + map[nr][nc]);
							return;
						}
						cur.c = nc;
						cur.r = nr;
					}
					else {
						System.out.println("Robot " + robotNum + " crashes into the wall");
						return;
					}
				}
				map[cur_c][cur_r] = 0;
				map[cur.c][cur.r] = robotNum;
				robotMap.put(robotNum, new Robot(cur.c, cur.r, cur.dir));
			}
		}
		System.out.println("OK");
	}
}

/*
--- Q ---
5 4
2 2
1 1 E
5 4 W
1 F 7
2 F 7
--- A ---
Robot 1 crashes into the wall

5 4
2 2
1 4 E
5 4 W
1 F 3
2 F 1
*/