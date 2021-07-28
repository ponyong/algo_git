package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_11437_LCA {
	static ArrayList<ArrayList<Integer>> list;
	static int[] depth;
	static int[] parent;

	private static void dfs(int cur) {

		for (int child : list.get(cur)) {

			if (depth[child] == 0) {

				parent[child] = cur;
				depth[child] = depth[cur] + 1;

				dfs(child);
			}
		}

	}

	private static int find(int a, int b) {

		while (depth[a] != depth[b]) {

			if (depth[a] < depth[b]) {
				b = parent[b];
			} else {
				a = parent[a];
			}
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer str;
		list = new ArrayList<ArrayList<Integer>>();

		depth = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < N - 1; i++) {
			str = new StringTokenizer(br.readLine());

			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());

			list.get(st).add(ed);
			list.get(ed).add(st);
		}

		depth[1] = 1;
		dfs(1);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());
			System.out.println(find(A, B));
		}
	}

}
