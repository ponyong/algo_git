package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2270_하노이탑 {
	static final int MOD = 1000000;
	static int[] powNum = new int[1000001];
	static int[] loc = new int[1000001];
	static int answer;
	public static void calPow(int n) {
		powNum[0] = 1;
		
		for(int i = 1; i <= n; i++) {
			powNum[i] = (powNum[i-1] << 1) % MOD;
		}
	}
	
	private static void hanoi(int disc, int to) {

		if(disc == 0) {
			return;
		}
		
		int cur = loc[disc];
		int tmp = 1 + 2 + 3 - cur - to;
		
		if(cur == to) {
			hanoi(disc - 1, to);
		}
		else {
			answer = (answer + powNum[disc - 1]) % MOD;
			hanoi(disc - 1, tmp);
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int ring1 = Integer.parseInt(str.nextToken());
		int ring2 = Integer.parseInt(str.nextToken());
		int ring3 = Integer.parseInt(str.nextToken());
		calPow(N);
		answer = 0;
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < ring1; i++) {
			int k = Integer.parseInt(str.nextToken());
			loc[k] = 1;
		}
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < ring2; i++) {
			int k = Integer.parseInt(str.nextToken());
			loc[k] = 2;
		}
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < ring3; i++) {
			int k = Integer.parseInt(str.nextToken());
			loc[k] = 3;
		}
		
		hanoi(N, loc[N]);
		System.out.println(loc[N]);
		System.out.println(answer);
	}
}
