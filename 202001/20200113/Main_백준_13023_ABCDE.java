package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main_백준_13023_ABCDE {
	static List[] list;
	static int N, M;
	static boolean flag;
	static boolean[] visit;
	public static void dfs(int num, int count) {
		
		if(flag) {
			return;
		}
		if(count == 5) {
			flag = true;
			return;
		}
		for(int i = 0; i < list[num].size(); i++) {
			if(!visit[(int) list[num].get(i)]) {
				visit[(int) list[num].get(i)] = true;
				dfs((int) list[num].get(i) , count + 1);
				visit[(int) list[num].get(i)] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		
		// 들어오는 값으로 인접리스트를 만든다.
		// 0에서 시작해서 5개를 선택할 때 까지 진행해본다.
		// 도중에 못가는 곳이 있으면 종료한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken()); // 정점 개수
		M = Integer.parseInt(str.nextToken()); // 간선의 개수
		
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visit = new boolean[N];
		for(int i = 0; i < M; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(temp.nextToken());
			int y = Integer.parseInt(temp.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		for(int i = 0; i < N; i++) {
			visit[i] = true;
			if(!flag) {
				dfs(i , 1);
			}
			else {
				break;
			}
			visit[i] = false;
		}
		if(flag) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
		
	}
}
