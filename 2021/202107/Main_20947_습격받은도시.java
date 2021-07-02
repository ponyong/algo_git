package Algo_Study_BOJ;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_20947_습격받은도시 {
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		boolean[][] visit = new boolean[N][N];
		Queue<Point> queue = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				char t = temp.charAt(j);

				map[i][j] = t;

				if (t == 'O') {
					queue.add(new Point(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			int r = cur.x;
			int c = cur.y;
			
			for(int i = 0; i < 4; i++) {
				
				int nr = r + dx[i];
				int nc = c + dy[i];
					
				while(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '.') {
					visit[nr][nc] = true;
					nr += dx[i];
					nc += dy[i];
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] == '.') {
					map[i][j] = 'B';
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
