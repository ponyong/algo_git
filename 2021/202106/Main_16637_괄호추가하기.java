package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_16637_괄호추가하기 {
	static List<Integer> num = new ArrayList<>();
	static List<Character> op = new ArrayList<>();
	static int ans;
	
	private static int calc(char op, int n1, int n2) {

		switch (op) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		}
		return -1;
	}
	private static void dfs(int idx, int sum) {
		
		if(idx >= op.size()) {
			ans = Math.max(ans, sum);
			return;
		}
		
        int next = calc(op.get(idx), sum, num.get(idx + 1));
        dfs(idx + 1, next);
 
        if (idx + 1 < op.size()) {
            int next2 = calc(op.get(idx + 1), num.get(idx + 1), num.get(idx + 2));
 
            dfs(idx + 2, calc(op.get(idx), sum , next2));
        } 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String q = br.readLine();
		ans = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) {
				num.add(q.charAt(i) - '0');
			}
			else {
				op.add(q.charAt(i));
			}
		}
		
		dfs(0, num.get(0));
		System.out.println(ans);
	}
}
