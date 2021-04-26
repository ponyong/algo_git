package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
	static int[] parent;
	
	private static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]);			
		}
	}
	private static void union(int x, int y) {

		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		parent = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int op = Integer.parseInt(str.nextToken());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			
			if(op == 0) {
				union(x, y);
			}
			else {
				if(find(x) == find(y)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}
}
