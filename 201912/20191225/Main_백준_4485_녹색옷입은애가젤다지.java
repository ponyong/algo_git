package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
	int x;
	int y;
	int value;
	
	public Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
public class Main_백준_4485_녹색옷입은애가젤다지 {

	static int[] dx = new int[] { 1, -1, 0 , 0 };
	static int[] dy = new int[] { 0,  0, -1, 1 };
	static int[][] map;
	static int[][] dist;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1;
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			
			// 0이면 끝
			if(N == 0) {
				return;
			}
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
					dist[i][j] = Integer.MAX_VALUE/2;
				}
			}
			int ans = solve();

			System.out.println("Problem " + cnt + ":" + " "  + ans);
			cnt++;
		}
	}
	private static int solve() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		dist[0][0] = map[0][0];
		queue.add(new Node(0, 0, map[0][0]));
		
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			
			if(dist[tmp.x][tmp.y] < tmp.value) {
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int ni = tmp.x + dx[i];
				int nj = tmp.y + dy[i];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < N) {
					
					if(dist[ni][nj] > dist[tmp.x][tmp.y] + map[ni][nj]) {
						dist[ni][nj] = dist[tmp.x][tmp.y] + map[ni][nj];
						queue.add(new Node(ni,  nj, dist[ni][nj]));
					}
				}
			}
		}
		return dist[N-1][N-1];
	}
}
