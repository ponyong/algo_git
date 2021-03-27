package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5525_IOIOI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		char[] S = br.readLine().toCharArray();
		
		int patten = 0;
		int result = 0;
		for(int i = 1; i < M - 1; i++) {
			if(S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
				patten++;
				i++;
				if(patten == N) {	
					result++;
					patten--;
				}
			}
			else {
				patten = 0;
			}
		}
		System.out.println(result);
	}
}
