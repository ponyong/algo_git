package Algo_Study_BOJ;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0;
		while(N > 0) {
			if(N % 5 == 0) {
				N -= 5;
				cnt++;
			}
			else if(N % 3 == 0) {
				N -= 3;
				cnt++;
			}
			else if(N > 5) {
				N -= 5;
				cnt++;
			}
			else {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
}
