package Algo_Study_BOJ;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(str.nextToken()));
		}
		
		int waitTime = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
			
			int cur = pq.poll();
			
			sum += waitTime + cur;
			waitTime += cur;
		}
		System.out.println(sum);
	}
}
