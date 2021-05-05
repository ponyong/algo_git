package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main_1806_부분합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int S = Integer.parseInt(str.nextToken());
		
		int[] arr = new int[N];
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		int left = 0;
		int right = 0;

		int sum = 0;
		int len = Integer.MAX_VALUE;
		while(true) {			
			
			if(S <= sum) {
				sum -= arr[left];
				left++;
				len = Math.min(len, right - left + 1);
			}
			else if(right == N) {
				break;
			}
			else {
				sum += arr[right];
				right++;
			}
		}
		
		if(len == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else {
			System.out.println(len);			
		}
	}
}
