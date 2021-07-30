package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4195_친구네트워크 {
	static Map<String, Integer> map;
	static int[] parent;
	static int no;

	private static int union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parent[aRoot] += parent[bRoot];
			parent[bRoot] = aRoot;
		}
		return parent[aRoot];
	}

	private static int find(int a) {
		if (parent[a] < 0) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			int M = Integer.parseInt(br.readLine());

			parent = new int[M * 2 + 1];

			Arrays.fill(parent, -1);

			map = new HashMap<String, Integer>();
			no = 0;

			for (int i = 0; i < M; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());

				String s1 = str.nextToken();
				String s2 = str.nextToken();
				System.out.println(Math.abs(union(s1, s2)));
			}
		}
	}
	private static int union(String s1, String s2) {

		Integer n1 = map.get(s1);
		Integer n2 = map.get(s2);

		if (n1 == null) {
			n1 = no++;
			map.put(s1, n1);
		}
		if (n2 == null) {
			n2 = no++;
			map.put(s2, n2);
		}

		return union(n1, n2);
	}
}
