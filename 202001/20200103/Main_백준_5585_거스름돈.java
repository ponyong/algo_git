package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_5585_거스름돈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int money = 1000 - N;
		
		// 500 100 50 10 5 1 이 무제한
		
		int cnt = 0;
		
		if(money > 500) {
			cnt += money / 500;
			money -= ( money / 500 ) * 500;
		}
		
		if(money > 100) {
			cnt += money / 100;
			money -= ( money / 100 ) * 100;
		}
		if(money > 50) {
			cnt += money / 50;
			money -= ( money / 50 ) * 50;
		}
		if(money > 10) {
			cnt += money / 10;
			money -= ( money / 10 ) * 10;
		}
		if(money > 5) {
			cnt += money / 5;
			money -= ( money / 5 ) * 5;
		}
		if(money > 1) {
			cnt += money / 1;
			money -= ( money / 1 ) * 1;
		}
		System.out.println(cnt);
		
	}
}
