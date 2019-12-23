package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_����_4963_���ǰ��� {
	public static int[] dx = { -1 , -1, -1, 0 , 0 , 1, 1, 1 }; // 8��
	public static int[] dy = { -1 ,  0,  1, -1, 1 , -1 , 0 , 1 }; // 8��
	public static int[][] map;
	public static boolean[][] visit;
	public static int cnt = 0;
	public static int W;
	public static int H;
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int k = 0; k < 8; k++) {
		
			int ni = x + dx[k];
			int nj = y + dy[k];
		
			if(ni >= 0 && ni < H && nj >= 0 && nj < W && !visit[ni][nj] && map[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		//������ �ʺ� w�� ���� h�� �־�����
		//h�� �ٿ��� ������ �־�����. 1�� ��, 0�� �ٴ��̴�.
		//0�� �� �� �־�����.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			W = Integer.parseInt(str.nextToken()); // �ʺ� 
			H = Integer.parseInt(str.nextToken()); // ����
			
			if(W == 0 && H == 0) {
				break;
			}
			map = new int[H][W]; 
			visit = new boolean[H][W];
			for(int i = 0; i < H; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
			cnt = 0;
		}
	}
}
