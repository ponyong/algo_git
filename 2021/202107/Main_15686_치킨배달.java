package Algo_Study_BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686_치킨배달 {
	static int N, M;
	static int[][] map;
	static List<Point> home, chicken;
	static int result;
	static boolean[] select;
	
	private static void dfs(int point, int cnt) {
		// M개의 가게를 골랐으면,
		if(cnt == M) {
			int sum = 0;
			// 각 집마다 가장 가까운 치킨집을 계산한다.
			for(int i = 0; i < home.size(); i++) {
				int min = 987654321;
				for(int j = 0; j < chicken.size(); j++) {
					if(select[j]) {
						// 두점 사이의 거리 ( x1 - 
						int cal = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);
						
						min = Math.min(min, cal);
					}
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = point; i < chicken.size(); i++) {
			select[i] = true; // 가게 뽑고
			dfs(i + 1, cnt + 1);
			select[i] = false;
		}
	}
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new int[N][N];
		
		home = new LinkedList<Point>();
		chicken = new LinkedList<Point>();
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++ ) {
				map[i][j] = Integer.parseInt(str.nextToken());
				
				if(map[i][j] == 1) {
					home.add(new Point(i,j));
				}
				else if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		result = Integer.MAX_VALUE;
		select = new boolean[chicken.size()];
		
		dfs(0, 0);
		System.out.println(result);
	}
}
