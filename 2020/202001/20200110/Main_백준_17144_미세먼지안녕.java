package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_17144_미세먼지안녕 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 행
		int M = Integer.parseInt(str.nextToken()); // 열
		int T = Integer.parseInt(str.nextToken()); // 공기청정기 가동시간
		int[][] map = new int[N][M];

		for(int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		for(int time = 1; time <=T; time++) {
			int[][] vi_map = new int[N][M];
			int[] cleaner = new int[2];
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == -1) {
						cleaner[0] = i;
						cleaner[1] = j;
					}
					if(map[i][j] > 0 && map[i][j] / 5 >= 0) {
						cnt = 0;
						if( i + 1 < N && map[i+1][j] != -1) {
							cnt++; 
							vi_map[i+1][j] += map[i][j] / 5;
						}
						if( i - 1 >= 0 && map[i-1][j] != -1) {
							cnt++; 
							vi_map[i-1][j] += map[i][j] / 5;
						}
						if( j + 1 < M  && map[i][j+1] != -1) {
							cnt++; 
							vi_map[i][j+1] += map[i][j] / 5;
						}
						if( j - 1 >= 0 && map[i][j-1] != -1) {
							cnt++; 
							vi_map[i][j-1] += map[i][j] / 5;
						}
					}
					vi_map[i][j] -= (map[i][j] / 5) * cnt;
					
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] += vi_map[i][j];
				}
			}

			int dir = 0;
			int temp = 0;
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {cleaner[0] - 1,cleaner[1]});
			while(!queue.isEmpty()) {
				int[] t = queue.poll();				
				// 오른쪽으로 갈때
				if(dir == 0) {
					if(t[1] + 1 < M) {
						int next = map[t[0]][t[1] + 1];
						queue.add(new int[] {t[0], t[1] + 1});
						map[t[0]][t[1]+1] = temp;
						temp = next;
					}
					else {
						queue.add(new int[] {t[0], t[1]});
						dir++;
					}
				}
				else if(dir == 1) {
					if(t[0] - 1 >= 0) {
						int next = map[t[0]-1][t[1]];
						queue.add(new int[] {t[0]-1, t[1]});
						map[t[0]-1][t[1]] = temp;
						temp = next;
					}
					else {
						queue.add(new int[] {t[0], t[1]});
						dir++;
					}
				}
				else if(dir == 2) {
					if(t[1] - 1 >= 0) {
						int next = map[t[0]][t[1]-1];
						queue.add(new int[] {t[0], t[1]-1});
						map[t[0]][t[1]-1] = temp;
						temp = next;
					}
					else {
						queue.add(new int[] {t[0], t[1]});
						dir++;
					}
				}
				else if(dir == 3) {
					if(t[0] + 1 < cleaner[0] - 1) {
						int next = map[t[0] + 1][t[1]];
						queue.add(new int[] {t[0] + 1, t[1]});
						map[t[0]+1][t[1]] = temp;
						temp = next;
					}
					else {
						dir++;
						break;
					}
				}
			}
			
			dir = 0;
			temp = 0;
			queue.clear();
			queue.add(new int[] {cleaner[0],cleaner[1]});
			while(!queue.isEmpty()) {
				int[] t = queue.poll();
				
				// 오른쪽으로 갈때
				if(dir == 0) {
					if(t[1] + 1 < M) {
						int next = map[t[0]][t[1] + 1];
						queue.add(new int[] {t[0], t[1] + 1});
						map[t[0]][t[1]+1] = temp;
						temp = next;
					}
					else {
						queue.add(new int[] {t[0], t[1]});
						dir++;
					}
				}
				else if(dir == 1) {
					if(t[0] + 1 < N) {
						int next = map[t[0]+1][t[1]];
						queue.add(new int[] {t[0]+1, t[1]});
						map[t[0]+1][t[1]] = temp;
						temp = next;
					}
					else {
						queue.add(new int[] {t[0], t[1]});
						dir++;
					}
				}
				else if(dir == 2) {
					if(t[1] - 1 >= 0) {
						int next = map[t[0]][t[1]-1];
						queue.add(new int[] {t[0], t[1]-1});
						map[t[0]][t[1]-1] = temp;
						temp = next;
					}
					else {
						queue.add(new int[] {t[0], t[1]});
						dir++;
					}
				}
				else if(dir == 3) { 
					if(t[0] - 1 > cleaner[0]) {
						int next = map[t[0] - 1][t[1]];
						queue.add(new int[] {t[0] - 1, t[1]});
						map[t[0]-1][t[1]] = temp;
						temp = next;
					}
					else {
						dir++;
						break;
					}
				}
			}
			dir = 0;
			temp = 0;
			queue.clear();
		}	
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (map[i][j]>0)
					sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}
