package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10797_10부제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 타겟 넘버
		
		StringTokenizer str = new StringTokenizer(br.readLine()); // 5대의 차량
		
		int cnt = 0;
		
		for(int i = 0 ; i < 5; i++) {
			if(Integer.parseInt(str.nextToken()) == T) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
