package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799_쇠막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Stack<Character> st = new Stack<Character>();
		int result = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				st.add(input.charAt(i));
				if(input.charAt(i + 1) == ')') {
					st.pop();
					result += st.size();
					i++;
					continue;
				}
				
			}
			else {
				st.pop();
				result++;
			}
		}
		System.out.println(result);
	}
}
