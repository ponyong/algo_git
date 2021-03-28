package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main_9461_파도반수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		long[] arr = new long[101];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i = 4; i < 101; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < TC; tc++) {
			
			sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(sb);
	}
}
