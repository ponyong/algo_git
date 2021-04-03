package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_5214_환승 {

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static List<List<Integer>> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		list = new LinkedList<>();

		int N = stoi(str.nextToken());
		int K = stoi(str.nextToken());
		int M = stoi(str.nextToken());

		int[] dist = new int[N + M + 1];
		boolean[] visit = new boolean[N + M + 1];

		for (int i = 1; i <= N + M + 1; i++) {
			list.add(new LinkedList<Integer>());
		}

		for (int i = N + 1; i <= N + M; i++) {
			str = new StringTokenizer(br.readLine());

			for (int j = 0; j < K; j++) {

				int X = stoi(str.nextToken());

				list.get(i).add(X);
				list.get(X).add(i);
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(1);
		visit[1] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == N) {
				break;
			}
			for (int node : list.get(cur)) {

				if (!visit[node]) {
					visit[node] = true;
					queue.add(node);
					dist[node] = dist[cur] + 1;
				}
			}
		}
		if (dist[N] == 0 && N != 1) {
			System.out.println(-1);
		} else {
			System.out.println((dist[N] / 2) + 1);
		}
	}
}
