package Algo_Study_Programmers;

import java.util.*;

public class Solution_크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int move : moves) {
        	for(int j = 0; j < board.length; j++) {
        		if(board[j][move - 1] != 0) {
        			if(st.isEmpty()) {
        				st.add(board[j][move - 1]);
        				board[j][move - 1] = 0;
        				break;
        			}
        			
        			if(board[j][move - 1] == st.peek()) {
        				st.pop();
        				answer += 2;
        			}
        			else {
        				st.add(board[j][move - 1]);
        			}
        			
        			board[j][move - 1] = 0;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[][] board = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = new int [] {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}
}
