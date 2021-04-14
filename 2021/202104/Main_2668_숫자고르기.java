package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_2668_숫자고르기 {
	static int[] arr;
	static boolean[] visit;
	static List<Integer> list;
	
	private static void dfs(int st, int ed) {
		
		if(!visit[arr[st]]) {
			visit[arr[st]] = true;
			dfs(arr[st], ed);
			visit[arr[st]] = false;
		}
		
		if(arr[st] == ed) {
			list.add(ed);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visit = new boolean[N + 1];
		list = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= N; i++) {
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
