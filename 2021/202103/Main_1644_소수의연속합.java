package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1644_소수의연속합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[N + 1];
		List<Integer> primeNum = new ArrayList<Integer>();
		isPrime[0] = isPrime[1] = true;
		
		for(int i = 2; i * i <= N; i++) {
			
			if(!isPrime[i]) {
				for(int j = i * i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		}
		for(int i = 2; i < isPrime.length; i++) {
			if(!isPrime[i]) {
				primeNum.add(i);
			}
		}
		
		int st = 0;
		int ed = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			if(sum >= N) {
				sum -= primeNum.get(st);
				st++;
			}
			else if(ed == primeNum.size()) {
				break;
			}
			else {
				sum += primeNum.get(ed);
				ed++;
			}
			
			if(sum == N) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
