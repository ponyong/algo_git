package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_16947_서울지하철2호선 {
	static List<Integer>[] metro;
	static boolean[] visit;
	static boolean[] cycle;
	
	private static boolean isCycle(int cur, int cnt, int start) {
		visit[cur] = true;
		
		for(int next : metro[cur]) {
			if(!visit[next]) {
				if(isCycle(next, cnt + 1, start)) {
					
				}
			}
			if(visit[next] && next == start && cnt >= 2) {
				// 다른곳을 돌아서 나한테 온것
				cycle[next] = true;
			}
			// 순환선 포함? 안포함?
			
			// 각 역시작으로 bfs 돌면서
			// cycle[찾는곳] = true? 
			// 거리 원하는 해답
			
			// 위상정렬 ? 
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		metro = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		cycle = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			metro[i] = new ArrayList<Integer>();
		}
		StringTokenizer str;
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			
			metro[u].add(v);
			metro[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			
			if(isCycle(i, 0, i)) {
				
			}
		}
	}
}
