package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_10817_세수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			list.add(Integer.parseInt(str.nextToken()));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(1));
	}
}
