package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_5565_영수증 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 9; i++) {
			int T = Integer.parseInt(br.readLine());
			
			N = N - T;
		}
		
		System.out.println(N);
	}
}
