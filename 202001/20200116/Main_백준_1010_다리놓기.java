package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1010_다리놓기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			
			StringTokenizer str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			
			long a = 1;
			
			for(int i = 1; i <= N; i++) {
				a = a * (M - i + 1) / i;
			}
			
			System.out.println(a);
		}
	}
}
