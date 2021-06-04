package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_21608_상어초등학교 {
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		int[][] map = new int[N + 1][N + 1];
		boolean[][] visit = new boolean[N + 1][N + 1];
		for (int i = 0; i <= N * N; i++) {
			list.add(new ArrayList<Integer>());
		}
		StringTokenizer str;

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N * N; i++) {
			str = new StringTokenizer(br.readLine());

			int cur = Integer.parseInt(str.nextToken());

			queue.add(cur);
			for (int j = 0; j < 4; j++) {
				list.get(cur).add(Integer.parseInt(str.nextToken()));
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			List<Integer> temp = list.get(cur);
			int target_x = 0;
			int target_y = 0;
			
			int target_like = 0;
			int target_empty = 0;
			
			boolean flag = false;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					
					
					if(visit[i][j]) {
						continue;
					}
					else if(map[i][j] == 0 && !flag) {
						target_x = i;
						target_y = j;
						flag = true;
					}
					int like = 0;
					int empty = 0;
					
					for(int k = 0; k < 4; k++) {
						
						int nr = i + dx[k];
						int nc = j + dy[k];
						
						if(nr >= 1 && nc >= 1 && nr <= N && nc <= N && map[nr][nc] == 0) {
							empty++;
							continue;
						}
						if(nr >= 1 && nc >= 1 && nr <= N && nc <= N && temp.contains(map[nr][nc])) {
							like++;
						}
					}

					if(target_like < like) {
						target_like = like;
						target_empty = empty;
						target_x = i;
						target_y = j;
					}
					else if(target_like == like) {
						if(target_empty < empty) {
							target_empty = empty;
							target_x = i;
							target_y = j;
						}
					}
				}
			}

			map[target_x][target_y] = cur;				
			visit[target_x][target_y] = true;
		}
		int result = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(map[i][j]);
				int match = 0;
				for(int k = 0; k < 4; k++) {
					int nr = i + dx[k];
					int nc = j + dy[k];
					
					List<Integer> temp = list.get(map[i][j]);
					if(nr >= 1 && nc >= 1 && nr <= N && nc <= N && temp.contains(map[nr][nc])) {
						match++;
					}
				}
				if(match == 0) {
					continue;
				}
				else if(match == 1) {
					result++;
				}
				else if(match == 2) {
					result += 10;
				}
				else if(match == 3) {
					result += 100;
				}
				else if(match == 4) {
					result += 1000;
				}
			}
			System.out.println();
		}		
		System.out.println(result);
	}
}
