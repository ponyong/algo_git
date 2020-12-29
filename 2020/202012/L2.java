package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L2 {
	static int[] arr;
	static boolean[] check;
	static int N, M;
	static int result;
	static int temp;
	static String[] sheets;
	static String answer, sheet;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		answer = br.readLine();
		sheet = br.readLine();
		sheets = sheet.split(",");
		
//		for(int i = 0; i < sheets.length; i++) {
//			System.out.println(sheets[i]);
//		}
		N = sheets.length;
		arr = new int[N+1];
		check = new boolean[N+1];
		M = 2;
		temp = 0;
		solve(0);
		
		System.out.println(result);
		
	}
		
	private static void solve(int cnt) {
		if(cnt ==  M) {
			
			String one = sheets[arr[0] - 1];
			String two = sheets[arr[1] - 1];
			
			for(int i = 0; i < one.length(); i++) {
				if(one.charAt(i) - '0' == two.charAt(i) - '0') {
					
					if(one.charAt(i) - '0' != answer.charAt(i) - '0') {
						temp++;
					}
				}
			}
			if(result < temp) {
				result = temp;
			}
			temp = 0;
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
