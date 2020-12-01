package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2745_진법변환 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		String N = str.nextToken();
		int B = Integer.parseInt(str.nextToken());
		
		System.out.println(trans(N, B));
	}

	private static int trans(String n, int b) {
		int result = 0;
		int pow = 0;
		for(int i = n.length() - 1; i >= 0; i--) {
			
			char tmp = n.charAt(i);
			
			if(tmp >= '0' && tmp <= '9') {
				result += (tmp - '0') * Math.pow(b, pow);
			}
			else if(tmp >= 'A' && tmp <= 'Z') {
				result += (tmp - ('A' - 10)) * Math.pow(b, pow);
			}
			
			pow++;
		}
		return result;
	}
}
