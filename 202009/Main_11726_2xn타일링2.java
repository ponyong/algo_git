package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11726_2xn타일링2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
		}
		System.out.print(dp[N]);
	}
}
