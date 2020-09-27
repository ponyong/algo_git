package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1935_후위표기식2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		Map<Character, Double> map = new HashMap<Character, Double>();
		
		for(int i = 0; i < N; i++) {
			map.put((char) (i + 65), Double.parseDouble(br.readLine()));
		}
		Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
 
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                switch (cur) {
                case '+':
                    stack.push(operand1 + operand2);
                    break;
                case '-':
                    stack.push(operand2 - operand1);
                    break;
                case '*':
                    stack.push(operand1 * operand2);
                    break;
                case '/':
                    stack.push(operand2 / operand1);
                    break;
                }
            } else {
                stack.push(map.get(cur));
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
	}
}
