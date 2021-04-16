package code_Chall_retry;

import java.util.Stack;

public class Solution_괄호회전하기 {
    public static int solution(String s) {
        int answer = 0;
        
        if(s.length() % 2 != 0) {
        	return answer;
        }
        for(int i = 0; i < s.length(); i++) {
        	
        	Stack<Character> st = new Stack<Character>();
        	
        	for(int j = 0; j < s.length(); j++) {
        		char temp = s.charAt(j);
        		
        		if(temp == '(' || temp == '{' || temp == '[') {
        			st.add(temp);
        		}
        		else {
        			if(temp == ')') {
        				if(!st.isEmpty() && st.peek() == '(') {
        					st.pop();
        				}
        				else {
        					st.add(temp);
        					break;
        				}
        			}
        			else if(temp == '}') {
        				if(!st.isEmpty() && st.peek() == '{') {
        					st.pop();
        				}
        				else {
        					st.add(temp);
        					break;
        				}
        			}
        			else if(temp == ']') {
        				if(!st.isEmpty() && st.peek() == '[') {
        					st.pop();
        				}
        				else {
        					st.add(temp);
        					break;
        				}
        			}
        		}
        	}
        	if(st.size() == 0) {
        		answer++;
        	}
        	
        	s = s.substring(1,s.length()) + s.charAt(0);
        }
        return answer;
    }
	public static void main(String[] args) {
		
		String s = "}]()[{";
		System.out.println(solution(s));
	}
}	
