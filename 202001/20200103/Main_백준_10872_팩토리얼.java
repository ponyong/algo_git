package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10872_팩토리얼 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));
	}

	private static int fact(int n) {
		
		if(n > 0) {
			return n * fact(n-1);
		}
		return 1;
	}
}
