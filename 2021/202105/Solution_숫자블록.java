package Algo_Study_Programmers;

import java.util.*;

public class Solution_숫자블록 {
    public static int cal(int num) {
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0 && (num / j) <= 10000000) {
                return num / j;
            }
        }
        return 1;
    }
	public static int[] solution(long begin, long end) {

        int st = (int) begin; 
        int ed = (int) end;
        
        int[] answer = new int[(ed - st) + 1];
		for (int i = st; i <= ed; i++) {

			if (i == 1) {
				answer[(i - st)] = 0;
				continue;
			}
            answer[i - st] = cal(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(1, 10);
	}
}
