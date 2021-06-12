package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1091_카드섞기 {
	static int[] P, S , first, temp;
	static int count, N;
	
	private static boolean isOk() {
		
		for(int i = 0; i < N; i++) {
			// 3명의 유저에게 순서대로 배치가 되지 않으면 셔플해야함
			if(P[i] != (i % 3)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isCycle() {
		
		for(int i = 0; i < N; i++) {
			
			// false를 리턴하지않고 for문을 통과하면 기존과 똑같은 것
			if(first[i] != P[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		
		P = new int[N];
		S = new int[N];
		
		first = new int[N];
		temp = new int[N];
		count = 0;
		str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(str.nextToken());
			// 초기값
			first[i] = tmp;
			// 변할값
			P[i] = tmp;
		}
		
		str = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			// 섞는 방법
			S[i] = Integer.parseInt(str.nextToken());
		}
		
		while(!isOk()) {
			
			for(int i = 0; i < N; i++) {
				temp[i] = P[i];
			}
			for(int i = 0; i < N; i++) {
				P[S[i]] = temp[i];
			}
			count++;
			// 섞었는데 초기 값과 같다 => 사이클로 인해 몇번을 섞어도 불가능
			if(isCycle()) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(count);
	}
}
