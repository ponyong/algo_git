package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_1759_암호만들기 {
	static int N, M;
	static char[] arr;
	static boolean[] check;
	
	public static void dfs(int index, int cnt, int moEum, int jaEum) {
		
		for(int i = index; i < M; i++) {
			
			check[i] = true;
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				dfs(i + 1, cnt + 1, moEum + 1, jaEum);
			}
			else {
				dfs(i + 1, cnt + 1, moEum, jaEum + 1);
			}
			check[i] = false;
		}
		
		if(cnt == N && moEum >= 1 && jaEum >= 2) {
			String tmp = "";
			
			for(int j = 0; j < M; j++) {
				if(check[j]) {
					tmp += arr[j];
				}
			}
			System.out.print(tmp + "\n");
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		arr = new char[M];
		check = new boolean[M];
		
		String[] tmp = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			arr[i] = tmp[i].charAt(0);
		}
		
		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
	}
}
