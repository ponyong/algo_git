package code_Challenge2;

import java.util.Arrays;

public class code1 {
    public static int solution(int left, int right) {
        int answer = 0;
		int[] arr = new int[1001];
		
		// 1은 전부 가지니까
		Arrays.fill(arr, 1);
		
		for(int i = 2; i <= right; i++) {
			
			for(int j = i; j <= right; j += i) {
				arr[j]++;
			}
		}
		for(int i = left; i <= right; i++) {
			if(arr[i] % 2 == 0) {
				answer += i;
			}
			else {
				answer -= i;
			}
		}
        return answer;
    }
	public static void main(String[] args) {
		int left = 24;
		int right = 27;
		
		System.out.println(solution(left, right));
		
	}
}
