package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
	int num;
	int weight;
	
	public Node(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}
	
}
public class Main_1939_중량제한 {
	static List<List<Node>> map;
	static int max;
	static int N, M;
	static boolean[] visit;
	private static boolean check(int start, int end, int mid) {
		
		for(int i = 0; i <= N; i++) {
			visit[i] = false;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			if(tmp == end) {
				return true;
			}
			
			for(Node cur : map.get(tmp)) {
				if(!visit[cur.num] && cur.weight >= mid) {
					queue.add(cur.num);
					visit[cur.num] = true;
				}
			}
		}
		return false;
	}
	private static int binarySearch(int start, int end) {
		
		int left = 1;
		int right = max;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(check(start, end, mid)) {
				if(mid > result) {
					result = mid;
				}
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		visit = new boolean[N + 1];
		map = new LinkedList<>();
		
		for(int i = 0; i <= N; i++) {
			map.add(new LinkedList<Node>());
		}
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(str.nextToken());
			int to = Integer.parseInt(str.nextToken());
			int weight = Integer.parseInt(str.nextToken());
			
			if(max < weight) {
				max = weight;
			}
				
			map.get(from).add(new Node(to, weight));
			map.get(to).add(new Node(from, weight));
		}
		
		str = new StringTokenizer(br.readLine());
				
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		
		System.out.println(binarySearch(start,end));
	}
}
