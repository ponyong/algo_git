package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Matrix implements Comparable<Matrix> {
	
	int r;
	int c;
	
	public Matrix(int r, int c) {
		this.r = r;
		this.c = c;
	}
	@Override
	public int compareTo(Matrix o) {
		if(this.r == o.r) {
			return this.c - o.c;
		}
		return this.r - o.r;
	}
	
}
public class Main_11650_좌표정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Matrix> pq = new PriorityQueue<Matrix>();
		StringTokenizer str;
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			
			pq.add(new Matrix(r, c));
		}
		
		while(!pq.isEmpty()) {
			Matrix cur = pq.poll();
			
			System.out.println(cur.r + " " + cur.c);
		}
	}
}
