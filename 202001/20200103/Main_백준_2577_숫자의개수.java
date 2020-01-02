package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2577_숫자의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int N = A * B * C;
		int[] map = new int[10];
		while(N != 0) {
			map[N % 10]++;
			N = N / 10;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(map[i]);
		}
	}
}
