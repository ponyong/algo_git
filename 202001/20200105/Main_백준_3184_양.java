package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main_백준_3184_양 {
	static int[] dx = new int[] { 1, -1 , 0 , 0 };
	static int[] dy = new int[] { 0 , 0 , 1 , -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][] visit = new boolean[N][M];
		int sheep_cnt = 0;
		int wolf_cnt = 0;
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'v') {
					wolf_cnt++;
				}
				if(map[i][j] == 'o') {
					sheep_cnt++;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'v' && !visit[i][j]) {
					int v_cnt = 0;
					int k_cnt = 0;
					queue.add(new int[] { i, j });
					
					visit[i][j] = true;
					while(!queue.isEmpty()) {
						int[] tmp = queue.poll();
						if(map[tmp[0]][tmp[1]] == 'v') {
							v_cnt++;
						}
						if(map[tmp[0]][tmp[1]] == 'o') {
							k_cnt++;
						}
						for(int k = 0; k < 4; k++) {
							
							int ni = tmp[0] + dx[k];
							int nj = tmp[1] + dy[k];
							
							if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != '#' && !visit[ni][nj]) {
								visit[ni][nj] = true;
								queue.add(new int[] { ni, nj }); 
							}
						}
					}
					if(v_cnt >= k_cnt) {
						sheep_cnt -= k_cnt;
					}
					else {
						wolf_cnt -= v_cnt;
					}
				}
			}
		}
		System.out.println(sheep_cnt + " " + wolf_cnt);
	} 
}
