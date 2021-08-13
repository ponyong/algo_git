package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1072_게임 {

	private static boolean check(long X, long Y, long mid, long Z) {
		if ((Y + mid) * 100 / (X + mid) != Z) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		long X = Integer.parseInt(str.nextToken());
		long Y = Integer.parseInt(str.nextToken());

		long Z = (Y * 100 / X);

		long st = 0;
		long ed = 1000000000;

		if (Z >= 99) {
			System.out.println(-1);
			return;
		}
		while (st <= ed) {

			long mid = (st + ed) / 2;

			if (check(X, Y, mid, Z)) {
				ed = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		System.out.println(st);
	}

}
