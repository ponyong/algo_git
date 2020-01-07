package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2309_일곱난쟁이 {
	
	static int[] N;	
	static int[] com = { 0, 0, 0, 0, 0, 0, 0 ,1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = new int[9];
		
		for(int i = 0; i < 9; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}
		
        Arrays.sort(N);
	
		do {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (com[i] == 0) {
					sum += N[i];
				}
			}
			if(sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (com[i] == 0) {
						System.out.println(N[i] + " ");
					}
				}
				return;
			}
		} while (np());
	}
// 4C2
	private static boolean np() {
	
		// 1. 교환이 필요한 위치 찾기 (i-1)
		int i = 9 - 1;
		while (i > 0 && com[i - 1] >= com[i])
			--i;
	
		if (i == 0)
			return false; // 이미 가장 큰 순열이므로 다음 순열 없음.
	
		// 2. i-1 위치값이랑 교환할 j 값 찾기 ( i-1 위치 뒤쪽에서 )
		int j = 9 - 1;
		while (com[i - 1] >= com[j])
			--j;
	
		// 3. i-1 위치값하고 j 위치값 교환
		int t = com[i - 1];
		com[i - 1] = com[j];
		com[j] = t;
	
		// 4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬
	
		j = 9 - 1;
	
		while (i < j) {
			t = com[i];
			com[i] = com[j];
			com[j] = t;
			++i;
			--j;
		}
		return true;
	}
}

