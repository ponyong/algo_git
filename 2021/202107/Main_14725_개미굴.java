package Algo_Study_BOJ;

import java.io.*;
import java.util.*;

class Cave {
	TreeMap<String, Cave> map;
	
	public Cave() {
		map = new TreeMap<String, Cave>();
	}
}

class Trie {
	Cave root;
	
	public Trie() {
		root = new Cave();
	}
	
	public void add(String[] input) {
		Cave cur = root;
		
		for(String s : input) {
			if(!cur.map.containsKey(s)) {
				cur.map.put(s, new Cave());
			}
			cur = cur.map.get(s);
		}
	}
	
	public void show(Cave cur, int depth) {
		for(String s : cur.map.keySet()) {
			
			for(int i = 0; i < depth; i++) {
				System.out.print("--");
			}
			System.out.println(s);
			
			Cave next = cur.map.get(s);
			show(next, depth + 1);
		}
	}
}
public class Main_14725_개미굴 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		Trie trie = new Trie();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str;
		
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(str.nextToken());
			String[] input = new String[K];
			for(int j = 0; j < K; j++) {
				input[j] = str.nextToken();
			}
			
			trie.add(input);
		}
		
		Cave root = trie.root;
		trie.show(root, 0);
	}
}
