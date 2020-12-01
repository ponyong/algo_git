package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ( { [ < 의 개수 를 담을 배열
		int[] list = new int[4];
		
		char[] array = br.readLine().toCharArray();
		int result = 0;
		for(int i = 0; i < array.length; i++) {
			
			char temp = array[i];
			
			if(temp == '(') {
				list[0]++;
			}
			if(temp == '{') {
				list[1]++;
			}
			if(temp == '[') {
				list[2]++;
			}
			if(temp == '<') {
				list[3]++;
			}
			
			if(temp == ')') {
				if(list[0] > 0) {
					result++;
					list[0]--;
				}
				else {
					result = -1;
					break;
				}
			}
			if(temp == '}') {
				if(list[1] > 0) {
					result++;
					list[1]--;
				}
				else {
					result = -1;
					break;
				}
			}
			if(temp == ']') {
				if(list[2] > 0) {
					result++;
					list[2]--;
				}
				else {
					result = -1;
					break;
				}
			}
			if(temp == '>') {
				if(list[3] > 0) {
					result++;
					list[3]--;
				}
				else {
					result = -1;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
