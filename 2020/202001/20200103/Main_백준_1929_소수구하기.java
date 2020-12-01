package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1929_소수구하기  {
	public static void main(String[] args) throws Exception {
		// M N 사이의 소수를 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		
		// N까지의 체크 배열 생성
		
		boolean[] check = new boolean[N+1];
		
		// 0,1은 예외 케이스 이므로 처리
		check[0] = true;
		check[1] = true;
		
		// 2부터 체크되지 않은 값은 소수임
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 2; i <= N; i++) {
			
			if(check[i] == false) {
				list.add(i);
			}
			for(int j = i * 2;  j <= N; j += i) {
				check[j] = true;
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			
			int t = list.get(i);
			
			if(t >= M && t <= N) {
				System.out.println(t);
			}
		}
	}
}
