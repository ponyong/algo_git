package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Jewel {
	int weight;
	int val;
	
	public Jewel(int weight, int val) {
		this.weight = weight;
		this.val = val;
	}
}
public class Main_1202_보석도둑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		List<Jewel> jewels = new ArrayList<Jewel>();
		List<Integer> bags = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o2 - o1;
			}
		});
		long result = 0;
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			jewels.add(new Jewel(w, v));
		}
		
		for(int i = 0; i < M; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(jewels, new Comparator<Jewel>() {

			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.weight <= o2.weight) {
					return -1;
				}
				else {
					return 1;					
				}
			}
		});
		Collections.sort(bags);
		
		int index = 0;
		for(int bag : bags) {
			
			while(index < N) {
				// 지금 가방크기로 넣을 수 있는 거 다 넣기
				if(bag < jewels.get(index).weight) {
					break;
				}
				else {
					pq.add((jewels.get(index).val));
					index++;
				}
			}
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		System.out.println(result);
		
		
	}
}
