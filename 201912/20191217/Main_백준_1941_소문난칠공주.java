package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Main_백준_1941_소문난칠공주 {
	static int[] num = new int[] { 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2,
			1, 0 };
	static int[] per = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 };

	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0,  0, 1, -1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int map[][] = new int[5][5];
		int sol[][] = new int[5][5];
		boolean[][] visit = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = tmp.charAt(j) - 'A';
			}
		}

		int quot = 0;
		int remain = 0;
		int result = 0;
		Queue<int[]> queue = new LinkedList<>();
		do {
			int s_cnt = 0;
			for(int k = 0; k < map.length; k++) {
				Arrays.fill(sol[k], 0);
				Arrays.fill(visit[k], false);	
			}
			queue.clear();
			int cnt = 0;
			for (int i = 0; i < num.length; i++) {
				if (per[i] == 1) {
					if(num[i] >= 5) {
						quot = num[i] / 5;
					}
					else {
						quot = 0;
					}
					remain = num[i] % 5;
					
					sol[quot][remain] = 1;
					if(queue.isEmpty()) {
						queue.add(new int[] { quot, remain });
						visit[quot][remain] = true;
						cnt++;
					}
					if(map[quot][remain] == 'S' - 'A') {
						s_cnt++;
					}
				}
			}
			// s진영이 4명이상이면 
			if(s_cnt >= 4) {
				while(!queue.isEmpty()) {
					int[] tmp = queue.poll();
					
					for(int i = 0; i < 4; i++) {
						
						int ni = tmp[0] + dx[i];
						int nj = tmp[1] + dy[i];
						
						if(ni >= 0 && nj >= 0 && ni < 5 && nj < 5 && !visit[ni][nj] && sol[ni][nj] == 1) {
							visit[ni][nj] = true;
							queue.add(new int[] { ni, nj });
							cnt++;
						}
					}
				}	
			}
			else {
				continue;
			}
			
			if(cnt == 7) {
				result++;
			}
		}while(np());
		System.out.println(result);
	}

	private static boolean np() {

		// 1. 교환이 필요한 위치 찾기 (i-1)
		int i = num.length - 1;
		while (i > 0 && per[i - 1] >= per[i])
			--i;

		if (i == 0)
			return false; // 이미 가장 큰 순열이므로 다음 순열 없음.

		// 2. i-1 위치값이랑 교환할 j 값 찾기 ( i-1 위치 뒤쪽에서 )
		int j = num.length - 1;
		while (per[i - 1] >= per[j])
			--j;

		// 3. i-1 위치값하고 j 위치값 교환
		int t = per[i - 1];
		per[i - 1] = per[j];
		per[j] = t;

		// 4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬

		j = num.length - 1;

		while (i < j) {
			t = per[i];
			per[i] = per[j];
			per[j] = t;
			++i;
			--j;
		}
		return true;
	}
}
