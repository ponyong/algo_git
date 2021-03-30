package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2606_바이러스 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		StringTokenizer str;
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			
			list.get(st).add(ed);
			list.get(ed).add(st);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(1);
		check[1] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next : list.get(cur)) {
				if(!check[next]) {
					cnt++;
					check[next] = true;
					queue.add(next);
				}
			}
		}
		System.out.println(cnt);
	}
}
