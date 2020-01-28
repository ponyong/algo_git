package ssafy;

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
		
		int[] one_list = new int[one_len + two_len];
		int[] two_list = new int[two_len];
		
		for(int i = 0; i < one_len; i++) {
			one_list[i] = one.charAt(i) - '0';
		}
		
		for(int i = 0; i < two_len; i++) {
			two_list[i] = two.charAt(i) - '0';
		}
		
		// 넣을 수 있는 자리의 수
		boolean flag = true;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < one_len; i++) {
			
			for(int j = 0; j < two_len; j++) {
				
				if(two_list[j] == 2) {
					
					if(one_list[i + j] == 2) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				if(i + two_len <= one_len) {
					min = Math.min(min, one_len);
				}
				else {
					min = Math.min(min, i + two_len + 1);
				}
			}
			flag = true;
		}
		System.out.println(min);
	}
}
