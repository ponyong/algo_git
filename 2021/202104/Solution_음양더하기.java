package code_Chall_retry;

public class Solution_음양더하기 {
    public static int solution(int[] absolutes, boolean[] signs) {
    
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
        	if(signs[i]) {
        		answer += absolutes[i];
        	}
        	else {
        		answer -= absolutes[i];
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] absolutes = new int[] { 4, 7 , 12};
		boolean[] signs = new boolean[] { true, false, true };
		
		System.out.println(solution(absolutes, signs));
		}
}
