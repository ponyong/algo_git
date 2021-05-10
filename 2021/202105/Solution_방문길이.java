package Algo_Study_Programmers;

import java.io.*;
import java.util.Map;

public class Solution_방문길이 {
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static int solution(String dirs) {
		boolean[][][][] map = new boolean[11][11][11][11];

		int r = 5;
		int c = 5;
		
		int answer = 0;
		int nr = 0;
		int nc = 0;
		for (int i = 0; i < dirs.length(); i++) {

			char next = dirs.charAt(i);
			int index = 0;
			switch (next) {
			case 'R':
				nr = r + dx[0];
				nc = c + dy[0];
				index = 0;
				break;
			case 'D':
				nr = r + dx[1];
				nc = c + dy[1];
				index = 1;
				break;
			case 'L':
				nr = r + dx[2];
				nc = c + dy[2];
				index = 2;
				break;
			case 'U':
				nr = r + dx[3];
				nc = c + dy[3];
				index = 3;
				break;
			}
			
			if(nr >= 0 && nc >= 0 && nr <= 10 && nc <= 10) {		
				if(!map[r][c][nr][nc] && !map[nr][nc][r][c]) {
					map[r][c][nr][nc] = true;
					map[nr][nc][r][c] = true;
					answer++;
				}
				r = nr;
				c = nc;
			}
			else {
				nr = r;
				nc = c;
				continue;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String dirs = "LULLLLLLU";
		System.out.println(solution(dirs));
	}
}
