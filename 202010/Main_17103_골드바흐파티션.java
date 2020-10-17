package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17103_골드바흐파티션 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[1000001];

		arr[1] = true;
		for (int i = 2; i <= 1000000; i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i + i; j <= 1000000; j += i) {
				arr[j] = true;
			}
		}

		for (int t = 0; t < tc; t++) {
			int cnt = 0;
			int N = Integer.parseInt(br.readLine());
			for (int i = 2; i <= N / 2; i++) {
				if (arr[i] == false && arr[N - i] == false) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
