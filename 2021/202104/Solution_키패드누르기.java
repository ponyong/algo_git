package Algo_Study_Programmers;

import java.util.*;
import java.awt.Point;
public class Solution_키패드누르기 {
	public static String solution(int[] numbers, String hand) {
	
		String answer = "";
		
		int left_x = 0;
		int left_y = 3;
		int right_x = 2;
		int right_y = 3;
		
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				map.put(j * 3 + i + 1, new Point(i,j));
			}
		}
		map.put(0, new Point(1,3));
		
		for(int number : numbers) {
			
			Point cur = map.get(number);
			if(number == 1 || number == 4 || number == 7) {
				answer += "L";
				left_x = cur.x;
				left_y = cur.y;
			}
			else if(number == 3 || number == 6 || number == 9) {
				answer += "R";
				right_x = cur.x;
				right_y = cur.y;
			}
			else {
				int cal_left = Math.abs(left_x - cur.x) + Math.abs(left_y - cur.y);
				int cal_right =  Math.abs(right_x - cur.x) + Math.abs(right_y - cur.y);
				
				if(cal_left == cal_right) {
					if(hand.equals("right")) {
						answer += "R";
						right_x = cur.x;
						right_y = cur.y;
					}
					else {
						answer += "L";
						left_x = cur.x;
						left_y = cur.y;
					}
				}
				else if(cal_left < cal_right) {
					answer += "L";
					left_x = cur.x;
					left_y = cur.y;
				}
				else {
					answer += "R";
					right_x = cur.x;
					right_y = cur.y;
				}
			}
		}
		return answer; 
	}

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}
}
