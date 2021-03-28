package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for(int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				String name = str.nextToken();
				String list = str.nextToken();
				if(map.containsKey(list)) {
					map.put(list, map.get(list) + 1);
				}
				else {
					map.put(list, 1);
				}
			}
			int result = 1;
			for(String key : map.keySet()) {
				result *= map.get(key) + 1;
			}
			System.out.println(result - 1);
		}
	}
}
