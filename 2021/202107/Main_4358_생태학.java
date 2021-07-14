package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

public class Main_4358_생태학 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String input = "";
		Map<String, Integer> map = new TreeMap<String, Integer>();
		int cnt = 0;
		while(sc.hasNextLine()) {
			
			input = sc.nextLine();
			cnt++;
			if(map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			}
			else {
				map.put(input, 1);
			}
		}
		for(String key : map.keySet()) {
			double num = (double)(map.get(key) * 100) / cnt;
			
			System.out.println(key + " " + String.format("%.4f", num));
		}
	}
}
