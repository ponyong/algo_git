package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class friends implements Comparable<friends> {

	int idx;
	int val;

	public friends(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}

	@Override
	public int compareTo(friends o) {
		return this.val - o.val;
	}

}

public class Main_16562_친구비 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());

		int[] arr = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		str = new StringTokenizer(br.readLine());

		PriorityQueue<friends> pq = new PriorityQueue<friends>();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
			pq.add(new friends(i, arr[i]));
		}

		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());

			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());

			list.get(st).add(ed);
			list.get(ed).add(st);
		}
		int sum = 0;
		Queue<friends> queue = new LinkedList<friends>();
		while (!pq.isEmpty()) {
			friends cur = pq.poll();

			if (!visit[cur.idx]) {
				sum += cur.val;
			}
			queue.add(cur);
			visit[cur.idx] = true;

			while (!queue.isEmpty()) {

				friends st = queue.poll();

				for (int next : list.get(st.idx)) {
					if (!visit[next]) {
						queue.add(new friends(next, 0));
						visit[next] = true;
					}
				}
			}
		}
		if (sum > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(sum);
		}
	}
}
