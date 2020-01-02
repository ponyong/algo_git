package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10039_평균점수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int t = Integer.parseInt(br.readLine());
			
			if(t < 40) {
				sum += 40;
			}
			else {
				sum += t;
			}
		}
		System.out.println(sum / 5);
	}
}
