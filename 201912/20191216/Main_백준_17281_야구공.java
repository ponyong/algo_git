package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17281_야구공 {
	static int[] player = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8}; // 초기 선수 배치
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inning = Integer.parseInt(br.readLine()); // 이닝 수
		
		int[][] result = new int[inning][9];
		max = Integer.MIN_VALUE;
		for(int i = 0; i < inning; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(temp.nextToken()); 
			}
		}
		do {
			// 4번타자가 1인 경우에만 로직 수행
			if(player[3] == 0) {
				int out_cnt = 0; // 아웃 카운트
				int inning_cnt = 0; // 이닝 카운트
				int player_cnt = 0; // 선수 카운트
				int[] map = new int[4]; // 1루 2루 3루 담을 배열
				int score = 0; // 점수
//				System.out.println(Arrays.toString(player));
				while(inning_cnt < inning) {
					// 해당 이닝의 선수가 아웃(0)이면 
					if(result[inning_cnt][player[player_cnt]] == 0) {
						out_cnt++;
						player_cnt = (player_cnt + 1) % 9;
						
						if(out_cnt == 3) {
							inning_cnt++;
							out_cnt = 0;
							Arrays.fill(map, 0);
						}
					}
					// 안타
					else if(result[inning_cnt][player[player_cnt]] == 1) {
						if(map[3] == 1) {
							score++;
						}
						map[3] = map[2];
						map[2] = map[1];
						map[1] = 1;
						player_cnt = (player_cnt + 1) % 9;
					}
					// 2루타
					else if(result[inning_cnt][player[player_cnt]] == 2) {
						if(map[3] == 1) {
							score++;
						}
						if(map[2] == 1) {
							score++;
						}
						map[3] = map[1];
						map[2] = 1;
						map[1] = 0;
						player_cnt = (player_cnt + 1) % 9;
					}
					// 3루타
					else if(result[inning_cnt][player[player_cnt]] == 3) {
						if(map[3] == 1) {
							score++;
						}
						if(map[2] == 1) {
							score++;
						}
						if(map[1] == 1) {
							score++;
						}
						map[3] = 1;
						map[2] = 0;
						map[1] = 0;
						player_cnt = (player_cnt + 1) % 9;
					}
					// 홈런
					else if(result[inning_cnt][player[player_cnt]] == 4) {
						if(map[3] == 1) {
							score++;
						}
						if(map[2] == 1) {
							score++;
						}
						if(map[1] == 1) {
							score++;
						}
						map[3] = 0;
						map[2] = 0;
						map[1] = 0;
						score++;
						player_cnt = (player_cnt + 1) % 9;
					}
				}
				max = score > max ? score : max;
			}
			else {
				continue;
			}
			
		} while(np());
		
		System.out.println(max);
		
//		for(int i = 1; i <= inning; i++) {
//			for(int j = 1; j <= 9; j++) {
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.println();
//		}
		

	}

	private static boolean np() {
		
		//1. 교환이 필요한 위치 찾기 (i-1) : 교환이 필요한 다음으로 가중치가 큰 자리
		int i = 8;
		while(i > 0 && player[i-1] >= player[i]) --i;
		
		if(i==0) return false; // 이미 가장 큰 순열이므로 다음 순열 없음.
		
		//2. i-1 위치값이랑 교환할 j 값 찾기 ( i-1 위치 뒤쪽에서 )
		// i-1 위치값 보다 크면서 이 자리에 올 수 있는 i-1  위치 뒤쪽에서의 가장 작은 값 ( 뒤 부터 탐색하면 조건 성립 )
		int j = 8;
		while(player[i-1] >= player[j]) --j;
		
		//3. i-1 위치값하고 j 위치값 교환
		int t = player[i-1];
		player[i-1] =player[j];
		player[j] = t;
		
		//4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬
		
		j = 8;
		
		while(i < j) {
			t = player[i];
			player[i] =player[j];
			player[j] = t;
			++i;
			--j;
		}
		return true;
	}
}
