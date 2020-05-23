package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class mids_01 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strs = new String[3];
		int ac = strs.length;
		String answer = "";
		strs[0] = "abcaefg";
		strs[1] = "abcdefg";
		strs[2] = "abcdhfg";
		
		int n = Math.min(strs[0].length(), strs[1].length());
		int m = Math.min(n, strs[2].length());
		for(int i = 0; i < m; i++) {
			int a = strs[0].charAt(i) - '0';	
			int b = strs[1].charAt(i) - '0';	
			int c = strs[2].charAt(i) - '0';
			
			if(a == b && b == c && c == a) {
				answer += strs[0].charAt(i);
			}
			else {
				break;
			}
		}
		System.out.println(answer);
	}
}
