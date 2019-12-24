package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_2644_촌수계산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int st = Integer.parseInt(str.nextToken());
		int ed = Integer.parseInt(str.nextToken());
		
		int M = Integer.parseInt(br.readLine()); // �����
		int[][] map = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(str.nextToken());
			int q = Integer.parseInt(str.nextToken());
			
			map[p][q] = 1;
			map[q][p] = 1;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] { st , 0 });
		visit[st] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			if(tmp[0] == ed ) {
				System.out.println(tmp[1]);
				return;
			}
			for(int k = 1; k <= N; k++) {
				if(map[tmp[0]][k] == 1 && !visit[k]) {
					visit[k] = true;
					queue.add(new int[] { k, tmp[1] + 1});
				}
			}
		}
		System.out.println("-1");
	}
}
