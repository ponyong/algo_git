package com.ssafy;

import java.util.Arrays;

public class NextPermutation_조합 {
	static int[] numbers = { 1, 2, 3, 4 };
	static int[] com = { 0, 0, 1, 1 };
	// 4C2
	static int N = 4;

	public static void main(String[] args) {
		Arrays.sort(com);

		do {
			for (int i = 0; i < N; i++) {
				if (com[i] == 1) {
					System.out.print(numbers[i] + " ");
				}
			}
			System.out.println();
		} while (np());
	}

	private static boolean np() {

		// 1. 교환이 필요한 위치 찾기 (i-1)
		int i = N - 1;
		while (i > 0 && com[i - 1] >= com[i])
			--i;

		if (i == 0)
			return false; // 이미 가장 큰 순열이므로 다음 순열 없음.

		// 2. i-1 위치값이랑 교환할 j 값 찾기 ( i-1 위치 뒤쪽에서 )
		int j = N - 1;
		while (com[i - 1] >= com[j])
			--j;

		// 3. i-1 위치값하고 j 위치값 교환
		int t = com[i - 1];
		com[i - 1] = com[j];
		com[j] = t;

		// 4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬

		j = N - 1;

		while (i < j) {
			t = com[i];
			com[i] = com[j];
			com[j] = t;
			++i;
			--j;
		}
		return true;
	}
}
