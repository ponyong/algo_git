package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main_1655_가운데를말해요 {
	static PriorityQueue<Integer> maxHeap, minHeap;
	
	private static void swap() {
		int temp = minHeap.poll();
		minHeap.add(maxHeap.poll());
		maxHeap.add(temp);
			
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		minHeap = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
		
		for(int i = 0; i < N; i++) {
			int curNum = Integer.parseInt(br.readLine());
			
			if(minHeap.size() == maxHeap.size()) {
				maxHeap.add(curNum);
			}
			else {
				minHeap.add(curNum);
			}
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					swap();
				}
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}

}
