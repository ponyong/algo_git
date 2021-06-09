package Algo_Study_BOJ;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<Point> queue;
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	private static int mod(int num) {
		while (num < 0)	num += N;
		return num % N;
	}
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		queue = new LinkedList<Point>();
		
		queue.add(new Point(N - 1, 0));
		queue.add(new Point(N - 1, 1));
		queue.add(new Point(N - 2, 0));
		queue.add(new Point(N - 2, 1));
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(str.nextToken()) - 1;
			int cnt = Integer.parseInt(str.nextToken());
			
			move(dir, cnt);
			waterCopy();
			makeCloud();
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result);
	}
	private static void move(int dir, int cnt) {
		int size = queue.size();
		// 현재 구름만큼만
		for(int i = 0; i < size; i++) {
			Point cur = queue.poll();
			
			int nx = mod(cur.x + dx[dir] * cnt);
			int ny = mod(cur.y + dy[dir] * cnt);
			
			map[nx][ny]++;
			queue.add(new Point(nx, ny));
		}
	}

	private static void waterCopy() {
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			// 구름이 사라진 칸
			visit[cur.x][cur.y] = true;
			// 대각선 1,3,5,7
			for(int i = 1; i < 8; i += 2) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				// 대각선은 범위 내에서만 체크
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0) {
					map[cur.x][cur.y]++;
				}
			}
		}
	}
	private static void makeCloud() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 구름이 사라진 칸 
				if(visit[i][j]) {
					visit[i][j] = false;
				}
				else {
					if(map[i][j] >= 2) {
						map[i][j] -= 2;
						queue.add(new Point(i,j));
					}
				}
			}
		}
	}


}
