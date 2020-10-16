package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 5; i <= N; i *= 5) {
			cnt += N / i;
		}
		System.out.println(cnt);
	}
}
