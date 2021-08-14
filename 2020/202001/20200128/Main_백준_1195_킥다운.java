package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1195_킥다운 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String one = br.readLine();
		String two = br.readLine();
		
		int one_len = one.length(); // 첫번째 길이
		int two_len = two.length(); // 두번째 길이
		
		if(one_len < two_len) {
			String tmp = one;
			one = two;
			two = tmp;
			
			int temp = one_len;
			one_len = two_len;
			two_len = temp;
		}
	
		// 넣을 수 있는 자리의 수
		int min = one_len + two_len;
		for(int gap = two_len - 1; gap >= -one_len + 1; gap--) {
			
			boolean flag = true; 
			int cnt = 0;
			for(int i = 0; i < two_len; i++) {
				
				int j = i - gap;
				if(j < 0 || j >= one_len) continue;
				
				if((two.charAt(i) -'0') + (one.charAt(j) - '0') > 3) {
					flag = false;
					break;
				}
				else {
					++cnt;
				}
			}
					
			if(flag) {
				min = Math.min(min, one_len + two_len - cnt);
			}
		}
		System.out.println(min);
	}
}
