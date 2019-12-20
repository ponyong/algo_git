package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//1       
//6      
//6       
//1 5     
//3 4     
//5 4
//4 2
//4 6
//5 2

public class Solution {
	static boolean[] check;
	static ArrayList[] up;
	static ArrayList[] down;
	static int cnt;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim()); // tc
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 학생수
			int M = Integer.parseInt(br.readLine().trim()); // 비교 횟수
			result = 0;
			up = new ArrayList[N+1]; // 나보다 큰 리스트
			down = new ArrayList[N+1]; // 나보다 작은 리스트
			check = new boolean[N+1];
			
			for(int i = 1; i <= N; i++) {
				up[i] = new ArrayList<Integer>(); 
				down[i] = new ArrayList<Integer>();
			}
			StringTokenizer str = null;
			for(int i = 0; i < M; i++) {
				str = new StringTokenizer(br.readLine());
				
				int loss = Integer.parseInt(str.nextToken()); // 작은 사람
				int win = Integer.parseInt(str.nextToken()); // 큰사람
				
				up[loss].add(win);
				down[win].add(loss);
			}
			cnt = 0;
			for(int i = 1; i <= N; i++) {
				Arrays.fill(check, false);
				dfs_u(i);
				Arrays.fill(check, false);
				dfs_d(i);
				
				if(cnt == N - 1) {
					result++;
				}
				cnt = 0;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void dfs_u(int i) {
		
		check[i] = true;
		
		for(int j = 0; j < up[i].size(); j++) {
			if(!check[(int) up[i].get(j)]) {
				cnt++;
				dfs_u((int)up[i].get(j));
			}
 		}	
	}
	private static void dfs_d(int i) {
		
		check[i] = true;
		
		for(int j = 0; j < down[i].size(); j++) {
			if(!check[(int) down[i].get(j)]) {
				cnt++;
				dfs_d((int)down[i].get(j));
			}
 		}	
	}
}
