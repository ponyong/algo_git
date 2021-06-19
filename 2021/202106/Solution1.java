package delivery;

import java.util.*;

public class Solution1 {
    public static String solution(String S, String C) {
    	
    	StringBuilder answer = new StringBuilder();
       
    	String[] names = S.split("; ");
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(int i = 0; i < names.length; i++) {
    		
    		String cur = names[i];
    		String email = "";
    		String[] name = cur.split(" ");
    		
    		email += name[0];
    		email += ".";
    		
    		String last = "";
    		// 미들네임이 있는 경우 
    		if(name.length > 2) {
    			last = name[2];
    		}
    		else {
    			last = name[1];
    		}
    		    		
    		int cnt = 0;
    		
    		for(int j = 0; j < last.length(); j++) {
    			
    			last = last.toLowerCase();
    			if(cnt >= 8) {
    				break;
    			}
    			if(last.charAt(j) >= 'a' && last.charAt(j) <= 'z') {
    				email += last.charAt(j);
    				cnt++;
    			}
                else if(last.charAt(j) - 'a' >= 0 && last.charAt(j) - 'a' <= 9) {
   				    email += last.charAt(j);
    				cnt++;
                }
    		}
  
    		if(!map.containsKey(email)) {
    			map.put(email, 1);
    		}
    		else {
    			int num = map.get(email) + 1;
    			map.put(email, map.get(email) + 1);
    			
    			email += num;
    		}
			email += "@";
    		email += C;
			email += ".com";	
    		answer.append(names[i] + " " + "<" + email.toLowerCase() + ">");
    		
    		if(i == names.length - 1) {

    		}
    		else {
    			answer.append("; ");
    		}
    	}
    	
    	return answer.toString();
    }
	public static void main(String[] args) {
		String S = "Johe Doe; Peter Benjamin Parker; Mary Jane Watson-Parker";
		String C = "Example";
		
		System.out.println(solution(S, C));
	}
}
