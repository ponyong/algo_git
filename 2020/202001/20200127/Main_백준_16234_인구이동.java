package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_16234_인구이동 {
	
	public static int[] dx = { 1, -1 , 0, 0 };
	public static int[] dy = { 0,  0 , -1, 1};
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken()); // MAP 크기 2
		int move = 0;
		List[] list = new ArrayList[N * N];
		map = new int[N][N];

		int L = Integer.parseInt(str.nextToken()); // MIN 값 20
		int R = Integer.parseInt(str.nextToken()); // MAX 값 50
		for(int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		while(true) {
			for(int i = 0; i < N * N; i++) {
				list[i] = new ArrayList<int[]>();
			}
			int cnt = 0;
			visit = new boolean[N][N];
			Queue<int[]> queue = new LinkedList<int[]>();
			for(int i = 0; i < N; i++) { 
				for(int j = 0; j < N; j++) {
					
					if(!visit[i][j]) {
						visit[i][j] = true;
						queue.add(new int[] { i, j });
						list[cnt].add(new int[] { i, j });
						while(!queue.isEmpty()) {
							int[] t = queue.poll();
							
							for(int k = 0; k < 4; k++) {
								int ni = t[0] + dx[k];
								int nj = t[1] + dy[k];
								
								if(ni >= 0 && nj >= 0 && ni < N && nj < N && L <= Math.abs(map[ni][nj] - map[t[0]][t[1]]) && Math.abs(map[ni][nj] - map[t[0]][t[1]]) <= R && !visit[ni][nj]) {
									visit[ni][nj] = true;
									queue.add(new int[] { ni, nj });
									list[cnt].add(new int[] { ni, nj });
								}
							}
						}
						cnt++;
					}
				}
			}
			int sum = 0;
			int move_cnt = 0;
			for(int i = 0; i < list.length; i++) {
				sum = 0;
				if(list[i].size() > 1) {
					for(int j = 0; j < list[i].size(); j++) {
						int[] t = (int[]) list[i].get(j);
						
						sum += map[t[0]][t[1]];
					}
					for(int j = 0; j < list[i].size(); j++) {
						int[] t = (int[]) list[i].get(j);
						
						map[t[0]][t[1]] = sum / list[i].size();
						move_cnt++;
					}
				}
			}

			move++;
			if(move_cnt == 0) {
				System.out.println(move - 1);
				return;
			}

		}
	}
}
