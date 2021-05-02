package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11047_동전0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		int[] arr = new int[N];
		
		for(int i = N - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		int idx = 0;
		while(K > 0) {
			if(K / arr[idx] > 0) {
				result += K / arr[idx];
				K = K % arr[idx];
				idx++;
			}
			else {
				idx++;
			}
		}
		System.out.println(result);
	}
}
