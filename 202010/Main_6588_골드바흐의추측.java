package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_6588_골드바흐의추측 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[1000001];
		
		arr[1] = true;
		for (int i = 2; i <= 1000000; i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i + i; j <= 1000000; j += i) {
				arr[j] = true;
			}
		}
		while (true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			boolean check = false;
			for(int i = 2; i <= N / 2; i++) {
				if(arr[i] == false && arr[N-i] == false) {
					System.out.println(N + " = " + i + " + " + (N -i));
					check = true;
					break;
				}
			}
			if(!check) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}

	}
}
