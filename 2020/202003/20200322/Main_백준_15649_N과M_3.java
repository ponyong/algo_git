package home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_백준_15649_N과M_3 {
	static int[] arr;
//	static boolean[] check = new boolean[9];
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		arr = new int[M];
		solve(0);
		br.close();
		bw.close();
	}

	private static void solve(int cnt) throws IOException {
		
		if(cnt ==  M) {
			
			for(int s : arr) {
				bw.write(s + " ");
			}
			bw.write("\n");
		}
		else {
			for(int i = 1; i <= N; i++) {
				arr[cnt] = i;
				solve(cnt + 1);
			}
		}

	}
}
