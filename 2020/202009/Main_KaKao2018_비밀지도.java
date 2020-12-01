package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_KaKao2018_비밀지도 {
	
	public static String changeString(int n, int num) {
		String result = "";
		
		for(int i = n - 1; i >= 0; i--) {
			if(Math.pow(2, i) <= num) {
				result += "1";
				num = num - (int)Math.pow(2, i);
			}
			else {
				result += "0";
			}
		}
		
		return result;
	}
    public static String[] solution(int n, int[] arr1 , int[] arr2) {
    	String[] answer = {"", "", "", "", ""};
    	
    	for(int i = 0; i < n; i++) {
    		String ans = "";
    		String num1 = changeString(n,arr1[i]);
    		String num2 = changeString(n,arr2[i]);
    		
    		for(int j = 0; j < n; j++) {
    			if(num1.charAt(j) == '0' && num2.charAt(j) == '0') {
    				ans += " ";
    			}
    			else {
    				ans += "#";
    			}
    		}
    		answer[i] = ans;
    		
    	}
    	return answer;
    }
	public static void main(String[] args) throws Exception {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		
		String[] temp = solution(n, arr1, arr2);
		
		for(int i = 0; i < n; i++) {
			System.out.println(temp[i]);
		}
	}
}
