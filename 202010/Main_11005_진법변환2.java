package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11005_진법변환2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int B = Integer.parseInt(str.nextToken());
		
		System.out.println(trans(N, B));
	}

	private static String trans(int n, int b) {
		
		String result = "";
		while(n != 0) {
			if( n % b < 10) {
				result = (n % b) + result;
				n /= b;
			}
			else {
				int tmp = (char)((n % b) + 55);
				
				result = (char)tmp + result;
				n /= b;
			}
		}
		return result;
	}
}
