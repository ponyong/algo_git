package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15649_N과M_2 {
	static int[] arr = new int[9];
	static boolean[] check = new boolean[9];
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		solve(0);
	}

	private static void solve(int cnt) {
		
		if(cnt ==  M) {
			
			for(int i = 0; i < M; i++) {
				System.out.print(arr[i]);
				if(i != M) {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		for(int i = 1; i <= N; i++) {
			
			if(!check[i]) {
				check[i] = true;
				arr[cnt] = i;
				if(cnt == 0) {
					solve(cnt + 1);
				}
				if(cnt > 0 && arr[cnt] > arr[cnt-1]) {
					solve(cnt + 1);
				}
				check[i] = false;
			}
		}
	}
}
