package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1561_놀이공원 {
	static final long MAX = 60000000000L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int[] times = new int[M];
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			times[i] = Integer.parseInt(str.nextToken());
		}
		if(N <= M) {
			System.out.println(N);
			return;
		}
		
		long left = 0;
		long right = MAX;
		
		long time = -1;
		while(left <= right) {
			long mid = ( left + right ) / 2;
			long child = M;
			
			for(int i = 0; i < M; i++) {
				child += mid / times[i];
			}

			if(child >= N) {
				time = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		time--;
		
		long answer = M;
		for(int i = 0; i < M; i++) {
			answer += time / times[i];
		}
		
		int leaveCnt = N - (int)answer;
		
		int index = 0;
		int cnt = 0;
		
		while(true) {
			if(((time + 1) / times[index]) != (time / times[index])) {
				cnt++;
			}
			index++;
			
			if(cnt == leaveCnt) {
				break;
			}
		}
		System.out.println(index);
	}
}
