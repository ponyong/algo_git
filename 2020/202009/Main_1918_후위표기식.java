package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_후위표기식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			
			char tmp = str.charAt(i);
			
			if(tmp == '(') {
				st.add(tmp);
			}
			else if(tmp == ')') {
				while(st.peek() != '(') {
					System.out.print(st.pop());
				}
				st.pop();
			}
			else if(tmp >= 'A' && tmp <= 'Z') {
				System.out.print(tmp);
			}
			else if(tmp == '*' || tmp == '/') {
				while(!st.empty() && (st.peek() == '*' || st.peek() =='/')) {
					System.out.print(st.pop());
				}
				st.add(tmp);
			}
			else if(tmp == '+' || tmp == '-') {
				while(!st.empty() && (st.peek() == '*' || st.peek() == '/' || st.peek() == '+' || st.peek() == '-')) {
					System.out.print(st.pop());
				}
				st.add(tmp);
			}
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}
}
