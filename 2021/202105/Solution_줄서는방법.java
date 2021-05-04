package Algo_Study_Programmers;

public class Solution_줄서는방법 {
	static int N;
	static boolean[] visit;
	public static void dfs(int idx, int cnt) {
		if(cnt == N) {
			
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, cnt + 1);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		N = 4;
		
		visit = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			visit[i] = true;
			dfs(i, 1);
			visit[i] = false;
		}
	}
}
