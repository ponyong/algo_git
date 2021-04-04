package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_2751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(pq.poll() + "\n");
		}
		
		System.out.print(sb.toString());
	}
}
