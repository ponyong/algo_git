package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_5543_상근날드 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int b_one = Integer.parseInt(br.readLine()); // 상버거
		int b_two = Integer.parseInt(br.readLine()); // 중버거
		int b_three = Integer.parseInt(br.readLine()); // 하버거
		
		int d_one = Integer.parseInt(br.readLine()); // 콜라
		int d_two = Integer.parseInt(br.readLine()); // 사이다
		
		int min_b = Math.min(b_one, b_two);
		min_b = Math.min(min_b, b_three);
		
		int min_d = Math.min(d_one, d_two);
		
		System.out.println(min_b + min_d - 50);
		
		
	}
}
