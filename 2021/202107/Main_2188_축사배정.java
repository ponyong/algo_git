package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2188_축사배정 {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visit;
	static int[] house;
	private static boolean dfs(int cow) {
		
		for(int i = 0; i < list.get(cow).size(); i++) {
			int view = list.get(cow).get(i);
			
			if(visit[view]) {
				continue;
			}
			
			visit[view] = true;
			
			if(house[view] == 0 || dfs(house[view])) {
				house[view] = cow;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		list = new ArrayList<ArrayList<Integer>>();
		visit = new boolean[201];
		house = new int[201];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= N; i++) {
			
			str = new StringTokenizer(br.readLine());
			
			int wants = Integer.parseInt(str.nextToken());
			
			for(int j = 1; j <= wants; j++) {
				
				int want = Integer.parseInt(str.nextToken());
				list.get(i).add(want);
			}
		}
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			
			Arrays.fill(visit, false);
			if(dfs(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
