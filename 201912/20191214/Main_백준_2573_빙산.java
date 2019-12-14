package train;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class ice {
	int x;
	int y;
	int ice;
	int breakIce;
	public ice(int x, int y , int ice, int breakIce) {
		this.x = x;
		this.y = y;
		this.ice = ice;
		this.breakIce = breakIce;
	}
	
	
}
public class Main_백준_2573_빙산_서울8반_권혁진 {
	static int[] dx = new int[] { 1, -1 , 0 , 0 };
	static int[] dy = new int[] { 0,  0 , 1 , -1 };
	static int cnt;
	static int zero_cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 행  5
		int M = Integer.parseInt(str.nextToken()); // 열  7
		
		ice[][] map = new ice[N][M];
		for(int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = new ice(i, j ,Integer.parseInt(temp.nextToken()), 0);
			}
		}
		int k = 0;
		while(true) {
			Queue<ice> queue = new LinkedList<ice>();
			boolean[][] flag = new boolean[N][M];
			cnt = 0;
			zero_cnt = 0;
			int max =0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j].ice == 0) {
						zero_cnt++;
					}
					else {
						if(flag[i][j] == false) {
							queue.add(map[i][j]);
							flag[i][j] = true;
							cnt++;
						}
						while(!queue.isEmpty()) {
							ice t = queue.poll();
							
							for(int a = 0; a < 4; a++) {
								int nii = t.x + dx[a];
								int njj = t.y + dy[a];
								
								if(nii >= 0 && nii < N && njj >= 0 && njj < M && map[nii][njj].ice != 0 && flag[nii][njj] == false) {
									flag[nii][njj] = true;
									queue.add(new ice(nii, njj, map[nii][njj].ice, map[nii][njj].breakIce));
								}
							}
						}
					}
				}
			}
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < M; j++) {
//					System.out.print(map[i][j].ice + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(cnt);
			if(cnt >= 2) {
				System.out.println(k);
				break;
			}
			else if(zero_cnt == N * M) {
				System.out.println(0);
				break;
			}
			zero_cnt = 0;
			k++;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j].ice > 0) {
						
						for( int p = 0;  p < 4; p++ ) {
							int ni = i + dx[p];
							int nj = j + dy[p];
							
							if(ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj].ice == 0) {
								map[i][j].breakIce++;
							}
						}
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j].ice > 0) {
						if(map[i][j].ice - map[i][j].breakIce < 0) {
							map[i][j].ice = 0;
						}
						else {
							map[i][j].ice -= map[i][j].breakIce;
						}
						map[i][j].breakIce = 0;
					}
				}
			}
			//BFS 로 떨어진 섬 몇갠지 찾기

		}
	}
}
