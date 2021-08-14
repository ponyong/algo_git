package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		// 가로면 0 대각선은 1 세로는 2
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] { 0, 1, 0 }); // 첫 좌표는 0,1로 가로 방향으로 되있음
		int cnt = 0; // 경우의 수 세는 방법
		
		while(!queue.isEmpty()) {
			
			int[] tmp = queue.poll();
			
			int x = tmp[0];
			int y = tmp[1];
			int role = tmp[2];
			
		}
	}
}
