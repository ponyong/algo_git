package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Fire {
	int r;
	int c;
	int m;
	int speed;
	int dir;
	
	public Fire(int r, int c, int m, int speed, int dir) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.speed = speed;
		this.dir = dir;
	}
}
public class Main_20056_마법사상어와파이어볼 {
	static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N;
	static ArrayList<Fire>[][] map;
	static Queue<Fire> queue;
	
	private static int mod(int num) {
		while(num < 0) num += N;
		return num % N;
	}

	private static void move() {
		int size = queue.size();
		
		for(int i = 0; i < size; i++) {
			Fire cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			int m = cur.m;
			int dir = cur.dir;
			int speed = cur.speed;
			
			int nr = mod(r + dx[dir] * speed);
			int nc = mod(c + dy[dir] * speed);
			
			map[nr][nc].add(new Fire(nr, nc, m, speed, dir));
		}
	}
	private static void union() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() == 0) {
					continue;
				}
				if(map[i][j].size() == 1) {
					queue.add(map[i][j].get(0));
					continue;
				}
				
				// 2칸 이상인 경우
				int weight = 0;
				int sp = 0;
				int odd = 0;
				int even = 0;
				for(Fire cur : map[i][j]) {
					weight += cur.m;
					sp += cur.speed;
					
					if(cur.dir % 2 == 0) {
						even++;
					}
					else {
						odd++;
					}
				}
				
				weight /= 5;
				sp /= map[i][j].size();
				
				if(weight == 0) {
					continue;
				}
				if(odd == 0 || even == 0) {
					queue.add(new Fire(i, j, weight, sp, 0));
					queue.add(new Fire(i, j, weight, sp, 2));
					queue.add(new Fire(i, j, weight, sp, 4));
					queue.add(new Fire(i, j, weight, sp, 6));
				}
				else {
					queue.add(new Fire(i, j, weight, sp, 1));
					queue.add(new Fire(i, j, weight, sp, 3));
					queue.add(new Fire(i, j, weight, sp, 5));
					queue.add(new Fire(i, j, weight, sp, 7));					
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Fire>();
			}
		}
	}
	private static int cal() {

		int answer = 0;
		int size = queue.size();
		for(int i = 0; i < size; i++) {
			answer += queue.poll().m;
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		map = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Fire>();
			}
		}	
		
		queue = new LinkedList<Fire>();
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int m = Integer.parseInt(str.nextToken());
			int dir = Integer.parseInt(str.nextToken());
			int speed = Integer.parseInt(str.nextToken());
			
			queue.add(new Fire(r - 1, c - 1, m, dir, speed));
		}
		
		for(int i = 0; i < K; i++) {
			
			move();
			union();
		}
		System.out.println(cal());
	}
}
