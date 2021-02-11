package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11653_소인수분해 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 2;
		while(N > 1) {
			
			if(N % cnt == 0) {
				System.out.println(cnt);
				N = N / cnt;
				cnt = 2;
			}
			else {
				cnt++;
			}
		}
		
		
	}
}
