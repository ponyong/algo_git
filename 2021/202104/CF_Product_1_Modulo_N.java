package Algo_Study_CodeForce;

import java.util.*;

public class Product_1_Modulo_N {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer> answer;
		int cnt = 1;

		while(true) {
			answer = new ArrayList<Integer>(); 
			int num = 1 + ( N * cnt++);
			
			if(cnt > 1000) {
				System.out.println(1);
				System.out.println(1);
				break;
			}
			for(int j = 1; j <= N; j++) {
				if(num % j == 0) {
					answer.add(j);
					num /= j;
				}
			}
			if(num == 1) {
				System.out.println(answer.size());
				for(int j = 0; j < answer.size(); j++) {
					System.out.print(answer.get(j) + " ");
				}
				break;
			}
		}
	}
}
