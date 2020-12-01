package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	private static int[][] map;
	private static int N;
	private static int M;
	private static int x;
	private static int y;
	private static int k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		x = Integer.parseInt(str.nextToken());
		y = Integer.parseInt(str.nextToken());
		k = Integer.parseInt(str.nextToken());
		
		map = new int[N][M];
		
		for(int x = 0; x < N; x++) {
			str = new StringTokenizer(br.readLine());
			for(int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(str.nextToken());
			}
		}
		
		int[] dx = new int[] { 0, 0, -1 , 1 };
		int[] dy = new int[] { 1,-1,  0 ,  0 };
		int[] dice = new int[7];
		
		int nx, ny;
		
		str = new StringTokenizer(br.readLine());
		
		while(k > 0) {
			int dir = Integer.parseInt(str.nextToken());
			nx = x + dx[dir - 1];
			ny = y + dy[dir - 1];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				int top = dice[1];
				
				if(dir == 1) {
					dice[1] = dice[4];
					dice[4] = dice[6];
					dice[6] = dice[3];
					dice[3] = top;
				}
				else if(dir == 2) {
					dice[1] = dice[3];
					dice[3] = dice[6];
					dice[6] = dice[4];
					dice[4] = top;
				}
				else if(dir == 3) {
					dice[1] = dice[5];
					dice[5] = dice[6];
					dice[6] = dice[2];
					dice[2] = top;
				}
				else {
					dice[1] = dice[2];
					dice[2] = dice[6];
					dice[6] = dice[5];
					dice[5] = top;
				}
				x = nx;
				y = ny;
				if(map[x][y] == 0) {
					map[x][y] = dice[6];
				}
				else {
					dice[6] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(dice[1]);
			}
			k--;
		}
		
	}
}
