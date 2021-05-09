package Algo_Study_Programmers;

import java.util.*;

public class Solution_튜플 {
    public static int[] solution(String s) {
        
        String temp = s.substring(2, s.length() - 2);
        
        String[] ns = temp.split("},\\{");
        
        Arrays.sort(ns , new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
        List<Integer> list = new ArrayList<Integer>();
        for(String tmp : ns) {
        	String[] arr = tmp.split(",");
        	
        	for(int i = 0; i < arr.length; i++) {
        		int num = Integer.parseInt(arr[i]);
        		
        		if(!list.contains(num)) {
        			list.add(num);
        		}
        	}
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		solution(s);
	}
}
