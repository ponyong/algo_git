package Algo_Study_Programmers;

import java.util.*;
class Road2 implements Comparable<Road2> {

	int r;
	int c;
	int cost;
	int dir;

	public Road2(int r, int c, int cost, int dir) {
		this.r = r;
		this.c = c;
		this.cost = cost;
		this.dir = dir;
	}

	@Override
	public int compareTo(Road2 o) {
		return this.cost - o.cost;
	}

}

public class Solution_경주로건설_re {
	static final int STRAIGHT = 100;
	static final int CORNER = 500;
	static int[] dx = new int[] { 1, 0, -1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int[][] map = new int[26][26];
	public static int solution(int[][] board) {
		int answer = 0;
		
		PriorityQueue<Road2> pq = new PriorityQueue<Road2>();
		pq.add(new Road2(0, 0, 0, 0));
		pq.add(new Road2(0, 0, 0, 1));
		
		for(int i = 0; i < board.length; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE / 2);
		}
		
		while(!pq.isEmpty()) {
			Road2 cur = pq.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dx[i];
				int nc = cur.c + dy[i];
				if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 0) {
					int ndir = 1;
					int ncost = 0;
					
					if(cur.r == nr) {
						ndir = 0;
					}
					if(cur.dir == ndir) {
						ncost += cur.cost +STRAIGHT;
					}
					else {
						ncost += cur.cost + STRAIGHT + CORNER;
					}
					
					if(map[nr][nc] >= ncost) {
						map[nr][nc] = ncost;
						pq.add(new Road2(nr, nc, ncost, ndir));
					}
				}
			}
		}
		return map[board.length - 1][board[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 1, 0 }, { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
		System.out.println(solution(board));
	}
}
