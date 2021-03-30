package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_1927_최소힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1 - o2;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			}
			else {
				pq.add(x);
			}
		}
		System.out.println(sb.toString());
	}
}
