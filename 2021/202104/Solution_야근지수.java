package Algo_Study_Programmers;

import java.util.*;

public class Solution_야근지수 {
	
    public static long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
        
        for(int i = 0; i < works.length; i++) {
        	pq.add(works[i]);
        }
        
        while(n > 0) {
        	n--;
        	
        	if(pq.peek() - 1 == 0) {
        		pq.poll();
        	}
        	else {
        		pq.add(pq.poll() - 1);
        	}
        }
        
        if(pq.size() == 0) {
        	return 0;
        }
        for(int cur : pq) {
        	answer += Math.pow(cur, 2);
        }
        return answer;
    }
	public static void main(String[] args) {
		int[] works = new int[] { 4, 3, 3 };
		int n = 4;
		
		System.out.println(solution(n, works));
	}
}
