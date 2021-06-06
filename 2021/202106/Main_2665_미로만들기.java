package Algo_Study_BOJ;

import java.io.*;
import java.util.*;
import java.awt.*;

public class Main_2665_미로만들기 {
	static final int INF = 987654321;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N]; // 숫자 
		int[][] cnt = new int[N][N]; // 검은색 몇개 

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
				cnt[i][j] = INF;
			}
		}

		cnt[0][0] = 0;
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0));
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && cnt[nx][ny] > cnt[cur.x][cur.y]) {
					if(map[nx][ny] == 1) {
						queue.add(new Point(nx,ny));
						cnt[nx][ny] = cnt[cur.x][cur.y];
					}
					else {
						queue.add(new Point(nx,ny));
						cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
					}
				}
			}
		}
		System.out.println(cnt[N - 1][N - 1]);
	}
}
