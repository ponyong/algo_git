package Algo_Study_BOJ;

import java.io.*;

public class Main_1065_한수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N < 100) {
			System.out.println(N);
			return;
		}
		
		int cnt = 0;
		for(int i = 100; i <= N; i++) {
			int hund = i / 100;
			int ten = (i % 100) / 10;
			int one = (i % 100) % 10;
			
			if((hund - ten) == (ten - one)) {
				cnt++;
			}
		}
		System.out.println(99 + cnt);
	}
}
