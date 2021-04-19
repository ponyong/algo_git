package Algo_Study_CodeForce;

import java.io.*;
import java.util.StringTokenizer;

public class Perfectly_Imperfect_Array {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[100001];
		
		for(int i = 1; i <= 100; i++) {
			arr[i * i] = true;
		}
		for(int tc = 0; tc < TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] val = new int[N];
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				val[i] = Integer.parseInt(str.nextToken());
			}
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				if(!arr[val[i]]) {
					flag = true;
				}
			}
			if(flag) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
