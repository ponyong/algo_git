package home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_15649_N과M_5 {
	static int[] arr;
	static boolean[] check;
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		arr = new int[N];
		check = new boolean[10001];
		
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);
		solve(0, "");
	}

	private static void solve(int cnt, String str) throws IOException {
		
		if(cnt ==  M) {
			System.out.println(str);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!check[arr[i]]) {
				check[arr[i]] = true;
				solve(cnt + 1, str + arr[i] + " ");
				check[arr[i]] = false;
			}
		}

	}
}
