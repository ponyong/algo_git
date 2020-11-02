package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10808_알파벳개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		int[] arr = new int[26];
		for(int i = 0; i < st.length(); i++) {
			arr[st.charAt(i) - 'a']++;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
