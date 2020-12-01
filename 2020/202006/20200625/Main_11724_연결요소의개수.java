package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	static int[] arr;
	static int[] rank;
	static int find(int x) {
		
		if( x == arr[x] ) return x;
		
		return arr[x] = find(arr[x]);
	}
	static void union(int x, int y) {

		
		if(rank[x] > rank[y]) {
			arr[y] = x;
		}
		else if(rank[x] < rank[y]) {
			arr[x] = y;
		}
		else {
			arr[y] = x;
			rank[x] += 1;
		}
	}
		
		
	public static void main(String[] args) throws Exception {
		
		
		// 유니온 파인드를 사용한다.
		// 두개의 값이 들어오면 두개의 부모를 확인하여 작은 값으로 바꿔준다.
		// 모든 과정이 끝나고 1~9 배열에서 있는 값들을 트루로 바꾸고
		// 트루의 개수를 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 정점 개수
		int M = Integer.parseInt(str.nextToken()); // 간선의 개수
		
		arr = new int[N+1];
		rank = new int[N+1];
		// Make Set
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
			rank[i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(temp.nextToken());
			int v = Integer.parseInt(temp.nextToken());
			if(( u = find(u)) != (v = find(v))) {
				union(u , v);				
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1; i <= N; i++) {
			set.add(find(arr[i]));
		}
		System.out.println(set.size());
		
		
	}
}
