package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_백준_1967_트리의지름 {
	static class Node {
		int num , dist; // 노드 번호, 거리
		
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
	static boolean[] visit;
	static int N, maxDist;
	static Node maxDistNode;
	static LinkedList<Node> tree[];
	public static void main(String[] args) throws Exception {
		// 트리의 최장 길이 = 루트에서 가장 먼곳 + 가장 먼곳에서 가장먼곳
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int parent, child, dist;
		String line[];
		N = Integer.parseInt(br.readLine());
		
		tree = new LinkedList[N];
		visit = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			tree[i] = new LinkedList<>();
		}
		
		for(int i = 1; i < N; i++) {
			line = br.readLine().split(" ");
			parent = Integer.parseInt(line[0]) - 1;
			child = Integer.parseInt(line[1]) - 1;
			dist = Integer.parseInt(line[2]);
			
			tree[parent].add(new Node(child, dist));
			tree[child].add(new Node(parent, dist));
		}
		
		for(Node root: tree[0]) {
			visit[0] = true;
			dfs(root, root.dist);
			visit[0] = false;
		}
		maxDist = 0;
		dfs(maxDistNode, 0);
		
		System.out.println(maxDist);
		
	}
	private static void dfs(Node curNode, int dist) {
		
		visit[curNode.num] = true;
		
		for(Node tmp : tree[curNode.num]) {
			if(!visit[tmp.num]) {
				visit[tmp.num] = true;
				dfs(tmp, dist+ tmp.dist);
				visit[tmp.num] = false;
			}
		}
		if(dist > maxDist) {
			maxDistNode = curNode;
			maxDist = dist;
		}
		
		visit[curNode.num] = false;
	}
}
