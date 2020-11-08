package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16968_차량번호판1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		int result = 1;
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				// 문자면 26가지
				if(arr[i] == 'c') {
					result *= 26;
				}
				else {
					result *= 10;
				}
			}
			else {
				if(arr[i] == 'c') {
					if(arr[i-1] == 'c') {
						result *= 25;
					}
					else {
						result *= 26;
					}
				}
				else {
					if(arr[i-1] == 'd') {
						result *= 9;
					}
					else {
						result *= 10;
					}
				}
			}
		}
		System.out.println(result);
	}
}
