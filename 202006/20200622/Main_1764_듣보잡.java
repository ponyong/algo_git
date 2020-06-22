package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 듣도 못한놈
		int M = Integer.parseInt(str.nextToken()); // 보도 못한놈
		
		Set<String> list = new HashSet<>();
		Set<String> sol = new HashSet<>();
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String temp = br.readLine();
			if(list.contains(temp)) {
				sol.add(temp);
			}
 		}
		List sort = new ArrayList(sol);
		
		Collections.sort(sort);
		System.out.println(sol.size());
		for(int i = 0; i < sol.size(); i++) {
			System.out.println(sort.get(i));
		}
	
	}
}
