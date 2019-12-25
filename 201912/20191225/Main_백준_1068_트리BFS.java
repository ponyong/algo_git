package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Main_백준_1068_트리BFS {
	static int[] list;
	static int[] count;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 노드의 개수

		ArrayList[] list = new ArrayList[N];
		boolean[] check = new boolean[N];
		int[] parent = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(str.nextToken());
		}
		
		int root = 0;
		
		for(int i = 0; i < N; i++) {
			int tmp = parent[i];
			
			if(tmp == - 1) {
				root = i;
				continue;
			}
			
			list[tmp].add(i);
			list[i].add(tmp);
		}
		
		int remove = Integer.parseInt(br.readLine());
		
		bfs(list, parent, check, remove);
		System.out.println(bfs(list, parent, check, root));
	}
	public static int bfs(ArrayList<Integer>[] a, int[] parent, boolean[] c, int remove) {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;

		if (c[remove]) {
			return 0;
		}
		
		q.add(remove);
		c[remove] = true;
		
		while(!q.isEmpty()) {
			remove = q.poll();
			boolean flag = false;
			
			for(int v : a[remove]) {
				if (!c[v] && parent[remove] != v) {
					// 방문하지 않았고, 부모정점과 현재 정점이 같지 않다면 탐색
					// 방문했거나, 부모정점과 같다면 탐색할 필요가 없다
					flag = true;
					q.add(v);
					c[v] = true;
				}	
			}	
			// 정점을 기준으로 탐색을 하지 못했을 경우 리프노드.
			if (!flag) {
				cnt++;
			}
			
		}
		return cnt;
	}
}
