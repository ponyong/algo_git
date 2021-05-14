package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_3020_개똥벌레 {
	static int N;
	private static int binarySearch(int l, int r, int height, int[] cave) {

		int min = Integer.MAX_VALUE;
		
		while(l <= r) {
			int mid = (l + r) / 2;
			
			if(height <= cave[mid]) {
				min = Math.min(min, mid);
				r = mid - 1;
			}
			else {
				l = mid + 1;
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			return 0;
		}
		else {
			return N / 2 - min;			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[] topDown = new int[N / 2];
		int[] downTop = new int[N / 2];
		
		int[] result = new int[M];
		for(int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());
			
			if(i % 2 == 0) {
				downTop[i / 2] = len;
			}
			else {
				topDown[i / 2] = len;
			}
		}
		
		Arrays.sort(topDown);
		Arrays.sort(downTop);
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= M; i++) {
			
			int td = binarySearch(0, N/2-1, i , topDown);
			int dt = binarySearch(0, N/2-1, M - i + 1, downTop);
			
			result[i - 1] = td + dt;
			min = Math.min(min, result[i - 1]);
		}
		
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			if(min == result[i]) {
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
	}

}
