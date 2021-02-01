package home;

import java.io.*;
import java.util.*;

public class Main_12851_숨바꼭질2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());

		boolean[] check = new boolean[100001];
		int[] dist = new int[100001];
		int[] cnt = new int[100001];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(N);
		check[N] = true;
		cnt[N] = 1;

		int[] view = new int[] { -1, +1, };
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur < 0 || cur > 100000) {
				continue;
			}

			for (int i = 0; i < 3; i++) {
				int tmp = 0;

				if (i == 0 && cur - 1 >= 0) {
					tmp = cur - 1;
				} else if (i == 1 && cur + 1 <= 100000) {
					tmp = cur + 1;
				} else if (i == 2 && cur * 2 <= 100000) {
					tmp = cur * 2;
				}
				if (!check[tmp]) {
					check[tmp] = true;
					dist[tmp] = dist[cur] + 1;
					queue.add(tmp);
					cnt[tmp] = cnt[cur];
				} else if (dist[tmp] == dist[cur] + 1) {
					cnt[tmp] += cnt[cur];
				}
			}
		}

		System.out.println(dist[K]);
		System.out.println(cnt[K]);
	}
}
