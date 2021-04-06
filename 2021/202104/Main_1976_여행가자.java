package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	static int[] parent;
	
	private static int find(int x) {
		
		while(x != parent[x]) {
			x = parent[x];
		}
	
		return x;
	}
	private static void union(int x, int y) {

		x = find(x);
		y = find(y);
		
		if(x < y) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		int[] route = new int[M + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		StringTokenizer str;
		for(int i = 1; i <= N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				
				int cur = Integer.parseInt(str.nextToken());
				
				if(cur == 1) {
					union(i,j);
				}
			}
		}
		
		str = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) {
			route[i] = Integer.parseInt(str.nextToken());
		}
		
		String result = "YES";
		
		for(int i = 1; i < M; i++) {
			if(find(route[i]) != find(route[i + 1])) {
				result = "NO";
				break;
			}
		}
		
		System.out.println(result);
	}

}
