package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] odd = new boolean[1001];
		odd[1] = true;
		for (int i = 2; i <= 1000; i++) {
			if (odd[i]) {
				continue;
			}
			for (int j = i + i; j <= 1000; j += i) {
				odd[j] = true;
			}
		}
		int result = 0;

		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			if (!odd[Integer.parseInt(str.nextToken())]) {
				result++;
			}
		}
		System.out.println(result);
	}
}
