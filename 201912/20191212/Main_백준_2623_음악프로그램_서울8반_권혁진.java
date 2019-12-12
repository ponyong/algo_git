package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2623_음악프로그램_서울8반_권혁진 {
	static class Node {
		int num;
		Node next;
		
		public Node(int num, Node next) {
			super();
			this.num = num;
			this.next = next;
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 가수의 수
		int M = Integer.parseInt(str.nextToken()); // PD의 수
		int[] arr = new int[N + 1];
		
		// 1부터 6까지 
		Node[] list = new Node[N + 1];
		
		for(int i = 0; i < M; i++) {
			
			StringTokenizer temp = new StringTokenizer(br.readLine());
			
			int view_num = Integer.parseInt(temp.nextToken()); // 한 pd가 보는 가수의 수
			int from = Integer.parseInt(temp.nextToken()); // 시작점
			list[from] = new Node(from, list[from]);
			for(int j = 0; j < view_num - 1; j++) {
				
				int to = Integer.parseInt(temp.nextToken()); // 도착점
				
				Node t = list[from];
				while(t.next != null) {
					t = t.next;
				}
				Node ne = new Node(to, null);
				t.next = ne;
				arr[to]++;
			}
			
		}
		Queue<Integer> queue = new LinkedList<>();
		int visitCnt = 0;
		for(int i = 1; i <= N; i++) {
			if(arr[i] == 0) {
				queue.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int t = queue.poll();
			visitCnt++;
			sb.append(t + "\n");
			Node temp = list[t];
			while(temp != null) {
				if(--arr[temp.num] == 0) {
					queue.add(temp.num);
				}
				temp = temp.next;
			}
		}

		if(visitCnt == N) {
			System.out.println(sb.toString());
		}
		else {
			System.out.println("0");
		}
	}
}
