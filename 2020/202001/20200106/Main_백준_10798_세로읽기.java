package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_10798_세로읽기  {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		List[] list = new ArrayList[15];
		
		for(int i = 0; i < 15; i++) {
			list[i] = new ArrayList<Character>();
		}
		
		for(int i = 0; i < 5; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < s.length(); j++) {
				list[j].add(s.charAt(j));
			}
		}
		
		for(int i = 0; i < 15; i++) {
			if(list[i].size() > 0) {
				for(int j = 0; j < list[i].size(); j++) {
					System.out.print(list[i].get(j));
				}
			}
		}
		
		
	}
}
