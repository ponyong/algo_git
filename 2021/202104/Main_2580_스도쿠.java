package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2580_스도쿠 {
	static int[][] map;
	static List<int[]> zero;
	public static boolean check(int r, int c, int val) {
		
		for(int i = 0; i < 9; i++) {
			if(map[r][i] == val) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {
			if(map[i][c] == val) {
				return false;
			}
		}
		
		int box_r = (r / 3) * 3;
		int box_c = (c / 3) * 3;
		
		for(int i = box_r; i < box_r + 3; i++) {
			for(int j = box_c; j < box_c + 3; j++) {
				if(map[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void sudoku(int cnt) {
		if(cnt == zero.size()) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		
		int r = zero.get(cnt)[0];
		int c = zero.get(cnt)[1];
		
		for(int i = 1; i <= 9; i++) {
			if(check(r, c, i)) {
				map[r][c] = i;
				sudoku(cnt + 1);
				map[r][c] = 0;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		zero = new ArrayList<int[]>(); 
		StringTokenizer str;
		for(int i = 0; i < 9; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				if(map[i][j] == 0) {
					zero.add(new int[] { i, j });
				}
			}
		}
		sudoku(0);
	}
}
