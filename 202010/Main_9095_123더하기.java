package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N + 1];
			
			if(N == 1) {
				System.out.println("1");
				continue;
			}
			else if(N == 2) {
				System.out.println("2");
				continue;
			}
			else if(N == 3) {
				System.out.println("4");
				continue;
			}
			
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			
			for(int i = 4; i <= N; i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			
			System.out.println(arr[N]);
		}
	}
}
