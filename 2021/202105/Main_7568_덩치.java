package Algo_Study_BOJ;

import java.io.*;
import java.util.*;
class Person {
	int weight;
	int height;
	
	public Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}
public class Main_7568_덩치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Person> list = new ArrayList<Person>();
		StringTokenizer str;
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(str.nextToken());
			int h = Integer.parseInt(str.nextToken());
			list.add(new Person(w, h));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int cnt = 1;
			Person cur = list.get(i);
			for(int j = 0; j < N; j++) {
				if(i == j) {
					continue;
				}
				Person view = list.get(j);
				
				if(cur.weight < view.weight && cur.height < view.height) {
					cnt++;
				}
			}
			sb.append(cnt + " ");
		}
		System.out.println(sb.toString());
	}
}	
