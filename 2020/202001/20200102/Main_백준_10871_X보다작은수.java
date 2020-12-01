package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10871_X보다작은수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int X = Integer.parseInt(str.nextToken());
		
		StringTokenizer tmp = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			
			int t = Integer.parseInt(tmp.nextToken());
			
			if( t < X ) {
				System.out.print(t + " ");
			}
		}
	}
}
