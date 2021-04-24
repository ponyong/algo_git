package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_1253_좋다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int target = arr[i];
			int left = 0; 
			int right = N - 1;
			
			int sum = 0;
			
			while(left < right) {
				sum = arr[left] + arr[right];
				
				if(sum == target) {
					if(left != i && right != i) {
						cnt++;
						break;
					}
					else if(left == i) {
						left++;
					}
					else if(right == i){
						right--;
					}
				}
				else if(sum < target) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		System.out.println(cnt);
	}
}
