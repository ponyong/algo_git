package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1748_수이어쓰기1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long result = 0;
		for(long i = 1; i <= N; i++) {
			if(i >= 1 && i <= 9) {
				result += 1;
			}
			else if(i >= 10 && i <= 99) {
				result += 2;
			}
			else if(i >= 100 && i <= 999) {
				result += 3;
			}
			else if(i >= 1000 && i <= 9999) {
				result += 4;
			}
			else if(i >= 10000 && i <= 99999) {
				result += 5;
			}
			else if(i >= 100000 && i <= 999999) {
				result += 6;
			}
			else if(i >= 1000000 && i <= 9999999) {
				result += 7;
			}
			else if(i >= 10000000 && i <= 99999999) {
				result += 8;
			}
			else if(i >= 100000000 && i <= 999999999) {
				result += 9;
			}
		}
		System.out.println(result);
	}
}
