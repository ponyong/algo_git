package Algo_Study_Programmers;

import java.util.*;

public class Solution_지형편집 {
	
	private static long cal(int[][] land, long mid, int P, int Q) {

		long tmp = 0;
		
		for(int i = 0; i < land.length; i++) {
			for(int j = 0;j < land.length; j++) {	
				
				if(land[i][j] == mid) {
					continue;
				}
				
				if(land[i][j] < mid) {
					tmp += (mid - land[i][j]) * P;
				}
				else {
					tmp += (land[i][j] - mid ) * Q;
				}
			}
		}
		return tmp;
	}
    public static long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
 
        long max = 0;
        long min = Long.MAX_VALUE;
        for(int i = 0; i < land.length; i++) {
        	for(int j = 0; j < land.length; j++) {
        		
        		min = Math.min(land[i][j], min);
        		max = Math.max(land[i][j], max);
        	}
        }

        Long st = min;
        Long ed = max;
        
        while(st <= ed) {
        	long mid = (st + ed) / 2;
        	
        	long leftCost = cal(land, mid, P, Q);
        	long rightCost = cal(land, mid + 1, P, Q);
        	
        	if(leftCost <= rightCost) {
        		answer = leftCost;
        		ed = mid - 1;
        	}
        	else {
        		answer = rightCost;
        		st = mid + 1;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] land = new int[][] {{ 4,4,3}, { 3,2,2}, { 2,1,0}};
		int P = 5;
		int Q = 3;
		
		System.out.println(solution(land, P, Q));
	}
}
