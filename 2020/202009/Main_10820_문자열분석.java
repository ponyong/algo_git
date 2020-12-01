package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10820_문자열분석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while(true) {
			if((input = br.readLine()) != null){
				int[] arr = new int[4];
				
				for(int i = 0; i < input.length(); i++) {
					char tmp = input.charAt(i);
					
					if(tmp >= 'a' && tmp <= 'z') {
						arr[0]++;
					}
					else if(tmp >= 'A' && tmp <= 'Z') {
						arr[1]++;
					}
					else if(tmp - '0' >= 0 && tmp - '9' <= 9) {
						arr[2]++;
					}
					else if(tmp == ' ') {
						arr[3]++;
					}
				}
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			else {
				break;
			}
		}
	}
}
