package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2490_윷놀이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0; i < 3; i++) {
			int[] tmp = new int[2];
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 4; j++) {
				tmp[Integer.parseInt(str.nextToken())]++;
			}
			
			if(tmp[0] == 1 && tmp[1] == 3) {
				System.out.println("A");
			}
			if(tmp[0] == 2 && tmp[1] == 2) {
				System.out.println("B");
			}
			if(tmp[0] == 3 && tmp[1] == 1) {
				System.out.println("C");
			}
			if(tmp[0] == 4 && tmp[1] == 0) {
				System.out.println("D");
			}
			if(tmp[0] == 0 && tmp[1] == 4) {
				System.out.println("E");
			}
		}
	}
}
