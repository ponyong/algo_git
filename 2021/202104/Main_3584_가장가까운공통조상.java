package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_3584_가장가까운공통조상 {
	static int parent[];
	public static int calDepth(int n) {
		
		int depth = 0;
		
		while(n != 0) {
			depth++;
			n = parent[n];
		}
		return depth - 1;
	}
	
	public static int find(int a, int b, int a_depth, int b_depth) {

		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		}
		else if(a_depth < b_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		}
		
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			
			int V = Integer.parseInt(br.readLine());
			
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			
			for(int i = 0; i <= V; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			parent = new int[V + 1];
			StringTokenizer str;
			for(int i = 0; i < V - 1; i++) {
				str = new StringTokenizer(br.readLine());
				
				int p = Integer.parseInt(str.nextToken());
				int c = Integer.parseInt(str.nextToken());
				
				parent[c] = p;
				list.get(p).add(c);
			}
			
			str = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			int a_depth = calDepth(a);
			int b_depth = calDepth(b);
			
			System.out.println(find(a, b, a_depth, b_depth));
		}
	}
}
