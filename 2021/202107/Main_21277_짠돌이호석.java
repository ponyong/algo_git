package Algo_Study_BOJ;

public class Main_21277_짠돌이호석 {
	public static int[][] rotate(int[][] cur) {
		
		int[][] next = new int[cur[0].length][cur.length];
		
		for(int i = 0; i < cur[0].length; i++) {
			for(int j = 0; j < cur.length; j++) {
				next[i][j] = cur[cur.length - 1 - j][i];
			}
		}
		return next;
	}
	public static void main(String[] args) {
		
		int[][] cur = new int[][] {{ 1,0,1}, {1,0,1},{1,0,1},{1,0,1}, {1,1,1}};
		
		int[][] map = new int[101][101];

		int[][] next = rotate(cur);
		int[][] next2 = rotate(next);
		int[][] next3 = rotate(next2);
		int[][] next4 = rotate(next3);
		for(int i = 0; i < next.length; i++) {
			for(int j = 0; j < next[0].length; j++) {
				System.out.print(next[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < next2.length; i++) {
			for(int j = 0; j < next2[0].length; j++) {
				System.out.print(next2[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < next3.length; i++) {
			for(int j = 0; j < next3[0].length; j++) {
				System.out.print(next3[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < next4.length; i++) {
			for(int j = 0; j < next4[0].length; j++) {
				System.out.print(next4[i][j] + " ");
			}
			System.out.println();
		}
	}
}
