package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1068_트리DP {
	static ArrayList[] list;
	static boolean[] check;
	static int[] D;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 노드의 개수

		list = new ArrayList[N];
		check = new boolean[N];
		int[] parent = new int[N];
		D = new int[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		StringTokenizer str = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(str.nextToken());
		}

		int root = 0;

		for (int i = 0; i < N; i++) {
			int tmp = parent[i];

			if (tmp == -1) {
				root = i;
				continue;
			}

			list[tmp].add(i);
		}

		int remove = Integer.parseInt(br.readLine());
		
		check[root] = true;
		dfs(root);
		
		if(parent[remove] != -1 && list[parent[remove]].size() == 1) {
			System.out.println(D[root] - D[remove] + 1);
			return;
		}
		System.out.println(D[root] - D[remove]);
	}

	private static void dfs(int cur) {
		boolean flag = false;

		for (int i = 0; i < list[cur].size(); i++) {
			int next = (int) list[cur].get(i);
			if (!check[next]) {
				flag = true;
				check[next] = true;
				dfs(next);
				D[cur] += D[next];
			}
		}
		// 내가 leaf인지 확인하기
		if (!flag) {
			D[cur] = 1;
		}
	}

}
