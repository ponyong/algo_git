package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3197_백조의호수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(str.nextToken());
		int C = Integer.parseInt(str.nextToken());
		
		char[][] map = new char[R][C];
		int[][] swan = new int[2][2];
		
		int swan_cnt = 0;
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[R][C] = tmp.charAt(j);
				
				if(map[R][C] == 'L') {
					swan[swan_cnt][0] = i;
					swan[swan_cnt][1] = j;
					
					swan_cnt++;
				}
			}
		}
	}
}
