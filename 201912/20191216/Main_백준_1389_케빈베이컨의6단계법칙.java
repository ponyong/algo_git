package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_1389_케빈베이컨의6단계법칙 {
	static int min;
	static int sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[][] map = new int[N+1][N+1];
		boolean[] check = new boolean[N + 1]; // 1~N 방문한 곳 체크하는 배열 
		min = Integer.MAX_VALUE;
		sum = 0;
		// 인접 행렬 구성
		for(int i = 0; i < M; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(temp.nextToken());
			int ed = Integer.parseInt(temp.nextToken());
			
			map[st][ed] = 1;
			map[ed][st] = 1;
		}
		// 시작점 1부터 N까지 돌면서 케빈 베이컨 값을 계산하여 갱신
		
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			// 체크 배열 초기화
			Arrays.fill(check, false);
			queue.clear();
			// 초기값과 케빈 베이컨 단계 (0) 을 삽입 
			check[i] = true;
			queue.add(new int[] { i , 0 });
			
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				sum += tmp[1];
				for(int j = 1; j <= N; j++) {
					if(map[tmp[0]][j] == 1 && !check[j]) {
						check[j] = true;
						queue.add(new int[] { j , tmp[1] + 1});
					}
				}
			}
			list.add(new int[] {sum, i});
			sum = 0;

		}
		int result = 0;
		for(int i = list.size() - 1; i >= 0; i--) {
			if(min >= list.get(i)[0]) {
				min = list.get(i)[0];
				result = list.get(i)[1];
			}
		}
		System.out.println(result);
		
	}
}
