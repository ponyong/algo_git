package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16948_데스나이트 {
	public static int[] dx = { -2, -2 , 0 , 0 , 2, 2 };
	public static int[] dy = { -1,  1 , -2, 2 , -1, 1};
	
 	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		Queue<int[]> queue = new LinkedList<int[]>();
		
		int night_x = Integer.parseInt(str.nextToken());
		int night_y = Integer.parseInt(str.nextToken());
		queue.add(new int[] { night_x , night_y , 0});
		visit[night_x][night_y] = true;
		
		map[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())] = 1;
		int sol = -1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(map[temp[0]][temp[1]] == 1) {
				sol = temp[2];
				break;
			}
			for(int i = 0; i < 6; i++) {
				int ni = temp[0] + dx[i];
				int nj = temp[1] + dy[i];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new int[] { ni, nj , temp[2] + 1});
				}
			}
		}
		System.out.println(sol);
		
	}
}
