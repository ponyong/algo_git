package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Toy {
	int num;
	int cnt;
	
	public Toy(int num , int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}
public class Main_2637_장난감조립 {
	static List<List<Toy>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<List<Toy>>();
		int[] indegree = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		int[][] dp = new int[N + 1][N + 1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Toy>());
		}
		StringTokenizer str;
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			int count = Integer.parseInt(str.nextToken());
			
			list.get(v).add(new Toy(u, count));
			indegree[u]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				check[i] = true;
				queue.add(i);
				dp[i][i] = 1;
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(Toy next : list.get(cur)) {
				
				for(int i = 1; i <= N; i++) {
					dp[next.num][i] += dp[cur][i] * next.cnt;
				}
				
				indegree[next.num]--;
				if(indegree[next.num] == 0) {
					queue.add(next.num);
				}
				
			}
		}
		for(int i = 1; i <= N; i++) {
			if(check[i]) {
				System.out.println(i + " " + dp[N][i]);
			}
		}
	}
}
