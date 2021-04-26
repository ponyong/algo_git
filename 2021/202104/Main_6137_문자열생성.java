package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6137_문자열생성 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
			
		String s = "";
		
		for(int i = 0; i < N; i++) {
			s += br.readLine();
		}
		
		int left = 0;
		int right = N - 1;
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(left <= right) {
			
			int l = left;
			int r = right;
			
			while(l + 1 < r) {
				if(s.charAt(l) == s.charAt(r)) {
					l++;
					r--;
				}
				else {
					break;
				}
			}
			
			char left_word = s.charAt(l);
			char right_word = s.charAt(r);
			if(cnt == 80) {
				sb.append("\n");
				cnt = 0;
			}
			if(left_word < right_word) {
				sb.append(s.charAt(left));
				left++;
			}
			else {
				sb.append(s.charAt(right));
				right--;
			}
			cnt++;
		}
		System.out.println(sb.toString());
	}
}
