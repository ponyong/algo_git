package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_KaKao2018_다트게임 {
    public static int solution(String dartResult) {
    	
    	char[] dartString = dartResult.toCharArray();
    	int cnt = 0;
    	int[] score = new int[3];
    	
    	for(int i = 0; i < dartString.length; i++) {
    		if(dartString[i] >= '0' && dartString[i] < '9') {
    			if(dartString[i] == '1' && dartString[i + 1] == '0') {
    				score[cnt] = 10;
    				i++;
    			}
    			else {
    				score[cnt] = dartString[i] - '0';
    			}
    			cnt++;
    		}
    		
    		if(dartString[i] == 'D') {
    			score[cnt-1] *= score[cnt-1]; 
    		}
    		if(dartString[i] == 'T') {
    			score[cnt-1] *= score[cnt-1] * score[cnt-1];
    		}
    		
    		if(dartString[i] == '#') {
    			score[cnt-1] *= -1; 
    		}
    		
    		if(dartString[i] == '*') {
    			if(cnt >= 2) {
    				score[cnt-2] *= 2;
    			}
    			score[cnt-1] *= 2;
    		}
    	}
        int answer = score[0] + score[1] + score[2];
        return answer; 
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());
		
		String s = str.nextToken();
		
		System.out.println(solution(s));
	}
}
