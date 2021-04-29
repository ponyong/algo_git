package Algo_Study_BOJ;

import java.io.*;

public class Main_1259_팰린드롬수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String s = br.readLine();
			
			if(s.charAt(0) == '0' && s.length() == 1) {
				break;
			}
			
			int left = 0;
			int right = s.length() - 1;
			boolean flag = false;
			
			while(left < right) {
				if(s.charAt(left) == s.charAt(right)) {
					left++;
					right--;
				} else {
					flag = true;
					break;
				}
			}
			if(flag) {
				System.out.println("no");
			}
			else {
				System.out.println("yes");
			}
		}
	}
}
