package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_21276_계보복원가호석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, List<String>> childs = new HashMap<String, List<String>>();
		Map<String, List<String>> parents = new HashMap<String, List<String>>();
		String[] input = br.readLine().split(" ");

		Arrays.sort(input);
		for (int i = 0; i < N; i++) {
			map.put(input[i], 0);
			childs.put(input[i], new ArrayList<String>());
			parents.put(input[i], new ArrayList<String>());
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer str;
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());

			String child = str.nextToken();
			String parent = str.nextToken();
			map.put(child, map.get(child) + 1);
			parents.get(parent).add(child);
		}
		
		List<String> boss = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < N; i++) {
			if(map.get(input[i]) == 0) {
				boss.add(input[i]);
				queue.add(input[i]);
			}
		}

		while (!queue.isEmpty()) {
			String cur = queue.poll();

			for (String child : parents.get(cur)) {

				map.put(child, map.get(child) - 1);


				if (map.get(child) == 0) {
					childs.get(cur).add(child);
					queue.add(child);
				}
			}
		}
		System.out.println(boss.size());
		for (String bo : boss) {
			System.out.print(bo + " ");
		}
		System.out.println();
		for (int i = 0; i < childs.size(); i++) {
			List<String> temp = childs.get(input[i]);
			Collections.sort(temp);
			int size = temp.size();
			System.out.print(input[i] + " " + size + " ");

			for (int j = 0; j < size; j++) {
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}
