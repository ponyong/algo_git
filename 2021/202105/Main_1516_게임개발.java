package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_1516_게임개발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] base = new int[N + 1];
		int[] count = new int[N + 1];
		int[] answer = new int[N + 1];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		StringTokenizer str;
		
		for(int i = 1; i <= N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int len = str.countTokens();
			base[i] = Integer.parseInt(str.nextToken());
			
			for(int j = 1; j < len; j++) {
				int before = Integer.parseInt(str.nextToken());
				
				if(before == -1) {
					break;
				}
				
				count[i]++;
				list.get(before).add(i);
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(count[i] == 0) {
				queue.add(i);
				answer[i] = base[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next : list.get(cur)) {
				
				answer[next] = Math.max(answer[next], answer[cur] + base[next]);
				count[next]--;
				
				if(count[next] == 0) {
					queue.add(next);
				}
				
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}
}
