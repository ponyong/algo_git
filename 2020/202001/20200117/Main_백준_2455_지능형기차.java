package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2455_지능형기차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			
			sum = sum - N;
			sum = sum + M;
			
			if(max < sum) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
