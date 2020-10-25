package home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15655_N과M_6 {
	static int[] arr;
	static boolean[] check;
	static int[] temp;
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		arr = new int[9];
		temp = new int[N];
		check = new boolean[9];

		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(temp);
		solve(0);
	}

	public static boolean check() {
		for (int i = 0; i < M - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}

	private static void solve(int cnt) throws IOException {

		if (cnt == M) {
			if (check()) {
				for (int i = 0; i < M; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[cnt] = temp[i];
				solve(cnt + 1);
				check[i] = false;
			}
		}

	}
}
