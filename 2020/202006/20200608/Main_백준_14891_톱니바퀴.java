package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14891_톱니바퀴 {
	static int[][] circle;
	static boolean[] visit;
	private static void role(int num, int dir) {
		visit[num] = true;
		int three = circle[num][2]; //회전 바퀴의 오른쪽
		int seven = circle[num][6]; //회전 바퀴의 왼쪽
		
		//일단 돌려
		// 정방향이면
		int tmp = 0;
		if(dir == 1) {
			tmp = circle[num][7];
			for(int i = 7; i > 0; i--)  {
				circle[num][i] = circle[num][i - 1];
			}
			circle[num][0] = tmp;
		}
		//역방향이면 
		else {
			tmp = circle[num][0];
			for(int i = 0; i < 7; i++) {
				circle[num][i] = circle[num][i + 1];
			}
			circle[num][7] = tmp;
		}
		if(num - 1 >= 0 && !visit[num-1]) {
			if(circle[num-1][2] != seven) {
				role(num-1, dir * -1);
			}
		}
		if(num + 1 <= 3 && !visit[num+1]) {
			if(circle[num+1][6] != three) {
				role(num+1, dir * -1);
			}
		}
			

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		circle = new int[4][8]; // 4개의 톱니가 8개의 이빨
		for(int i = 0; i < 4; i++) {
			String t = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				
				circle[i][j] = t.charAt(j) - '0'; 
			}
		}
		int T = Integer.parseInt(br.readLine()); // 회전 횟수
		
		StringTokenizer str = null;
		for(int i = 0; i < T; i++) {
			str = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(str.nextToken()); // 회전 톱니
			int dir = Integer.parseInt(str.nextToken()); // 회전 방향
			
			visit = new boolean[4];
			role(num - 1, dir);
		}
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			if(circle[i][0] == 1) {
				sum += Math.pow(2, i);
			}
		}
		System.out.println(sum);

	}
}
