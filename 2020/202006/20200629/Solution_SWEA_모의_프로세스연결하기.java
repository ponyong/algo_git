package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_모의_프로세스연결하기 {
	static class Process {
		int x; // 프로세스의 x 좌표
		int y; // 프로세스의 y 좌표

		Process(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0 , 0};
	static int[] dy = { 0, 0 , -1 , 1};
	
	static ArrayList<Process> Prolist;
	static int min;
	static int max;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N][N];
			Prolist = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 만약 입력 값이 프로세스(1) 이면서
					if(map[i][j] == 1) {
						// 벽에 있는 프로세인 경우 pass
						if(i - 1 < 0 || j - 1 < 0 || i + 1 >= N || j + 1 >= N) {
							continue;
						}
						else {
							// 아닌 경우 리스트에 저장 
							Prolist.add(new Process(i, j)); 
						}
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			dfs(0,0,0);
			
			System.out.println("#" + tc + " " + min);
		} 
	}
	public static void dfs(int idx, int coreCnt, int len) {
		
		// 모든 프로세스를 순회 했을 때: 종료 조건 
		if(idx == Prolist.size()) {
			// 코어 개수가 더 많은 경우
			if(max < coreCnt) {
				max = coreCnt;
				min = len;
			}
			// 코어 개수가 같은 경우
			else if(max == coreCnt) {
				if(min > len) {
					min = len;
				}
			}
			return;
		}
		int x = Prolist.get(idx).x;
		int y = Prolist.get(idx).y;
		
		for(int dir = 0; dir < 4; dir++) {
			int count = 0;
			int ori_x = x;
			int ori_y = y;
			int nx = x;
			int ny = y;
			
			while(true) {
				nx += dx[dir];
				ny += dy[dir];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
					break;
				}
				
				if(map[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}
			
			for(int i = 0; i < count; i++) {
				ori_x += dx[dir];
				ori_y += dy[dir];
				
				map[ori_x][ori_y] = 1;
			}
			if(count == 0) {
				dfs(idx + 1, coreCnt , len);
			}
			else {
				dfs(idx + 1 , coreCnt + 1, len + count);
				
				ori_x = x;
				ori_y = y;
				for(int i = 0; i < count; i++) {
					ori_x += dx[dir];
					ori_y += dy[dir];
					
					map[ori_x][ori_y] = 0;
				}
			}
		}
	}
}
