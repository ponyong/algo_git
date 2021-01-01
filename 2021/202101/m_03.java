package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class m_03 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[][] {{1,1,3,3},{4,1,3,4},{1,2,1,1},{2,1,3,2}};
		int cnt = 0;
		board[2][1] = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println(board.length);
		for(int i = board.length - 1; i >= 0; i--) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 0) {
					for(int k = i; k > 0; k--) {
						board[k][j] = board[k - 1][j]; 
					}
				}
			}
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		
	}
}
