package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7453_합이0인네정수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[N][4];
		StringTokenizer str;
		for(int i = 0; i < N; i++) {
			
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		List<Long> list = new ArrayList<Long>();
		long[] AB = new long[N * N];
		long[] CD = new long[N * N];
	
		int index = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				AB[index] = arr[i][0] + arr[j][1];
				CD[index] = arr[i][2] + arr[j][3];
				index++;
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int left = 0;
		int right = N * N - 1;
		
		long answer = 0;
		while(left < N * N && right >= 0) {
			long left_val = AB[left];
			long right_val = CD[right];
			
			if(left_val + right_val == 0) {
				long left_cnt = 0;
				
				while(left < AB.length && AB[left] == left_val) {
					left++;
					left_cnt++;
				}
				
				long right_cnt = 0;
				
				while(right >= 0 && CD[right] == right_val) {
					right--;
					right_cnt++;
				}
				
				answer += left_cnt * right_cnt;
			}
			else if(left_val + right_val < 0) {
				left++;
			}
			else {
				right--;
			}
			
		}
		System.out.println(answer);
	}
}
