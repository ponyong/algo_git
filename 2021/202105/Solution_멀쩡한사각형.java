package Algo_Study_Programmers;

public class Solution_멀쩡한사각형 {
	public static long solution(int w, int h) {
		long answer = w * h;
		
		if(w == h) {
			answer -= w;
			return answer;
		}
		
		answer -= w + h - gcd(w, h);
		
		return answer;
	}
	
	private static int gcd(int w, int h) {
		
		if(w > h) {
			int tmp = w;
			w = h;
			h = tmp;
		}
		
		while(w != 0) {
			int t = h % w;
			h = w;
			w = t;
		}
		return w;
	}

	public static void main(String[] args) {
		solution(8, 12);
	}
}
