package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for(int i = 1; i <= N; i++) {
			String temp = br.readLine();
			map.put(i, temp);
			map2.put(temp, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			String s = br.readLine();
			
			if(Character.isDigit(s.charAt(0))) {
				int tmp = Integer.parseInt(s);
				sb.append(map.get(tmp) + "\n");
			}
			else {
				sb.append(map2.get(s) + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
