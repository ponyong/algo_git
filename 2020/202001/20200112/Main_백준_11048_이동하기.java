package home;

import java.util.*;

public class Main_백준_11048_이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt(); // 행
		int col = sc.nextInt(); // 열
		
		// 행렬 생성
		int[][] map = new int[row][col];
		
		// 초기값 
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int start = map[0][0]; // 초기값
		int pre = start; // 전 값
		int max = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				
				// 둘다 0보다 작으면 초기값
				if(i - 1 < 0 && j - 1 < 0 ) {
					continue;
				}
				// i만 작고 j는 크면 제일 윗줄
				else if (i - 1 < 0  && !(j - 1 < 0)) {
					map[i][j] = map[i][j] + map[i][j-1];
				}
				// j만 작고 i는 크면 제일 왼쪽줄
				else if (!(i - 1 < 0) && j - 1 < 0) {
					map[i][j] = map[i][j] + map[i-1][j];
				}
				else {
					max = Math.max(map[i-1][j], map[i-1][j-1]);
					max = Math.max(max, map[i][j-1]);
					
					map[i][j] = map[i][j] + max;	
				}
				
			}
			
		}
		System.out.println(map[row-1][col-1]);
	}
}
