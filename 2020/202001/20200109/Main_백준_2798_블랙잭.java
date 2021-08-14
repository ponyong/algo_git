package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2798_블랙잭 {
	static int N;
	static int[] val;
	static int[] check;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken()); // 카드 개수

		int target = Integer.parseInt(str.nextToken()); // 목표 점수

		val = new int[N];

		check = new int[N];

		check[0] = 1;
		check[1] = 1;
		check[2] = 1;
		str = new StringTokenizer(br.readLine());

		Arrays.sort(check);
		for (int i = 0; i < N; i++) {
			val[i] = Integer.parseInt(str.nextToken());
		}
		int max = Integer.MIN_VALUE;
		do {
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				if(check[i] == 1) {
					sum += val[i];
				}
			}
			if(sum <= target && max < sum) {
				max = sum;
			}
		} while (np());
		
		System.out.println(max);
	}

	private static boolean np() {

		// 1. 교환이 필요한 위치 찾기 (i-1)
		int i = N - 1;
		while (i > 0 && check[i - 1] >= check[i])
			--i;

		if (i == 0)
			return false; // 이미 가장 큰 순열이므로 다음 순열 없음.

		// 2. i-1 위치값이랑 교환할 j 값 찾기 ( i-1 위치 뒤쪽에서 )
		int j = N - 1;
		while (check[i - 1] >= check[j])
			--j;

		// 3. i-1 위치값하고 j 위치값 교환
		int t = check[i - 1];
		check[i - 1] = check[j];
		check[j] = t;

		// 4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬

		j = N - 1;

		while (i < j) {
			t = check[i];
			check[i] = check[j];
			check[j] = t;
			++i;
			--j;
		}
		return true;
	}
}
