package Algo_Study_BOJ;

import java.io.*;
import java.util.*;
class number {
	
	boolean isLeaf;
	number[] child;
	
	public number() {
		this.isLeaf = false;
		this.child = new number[10];
	}
}
public class Main_5052_전화번호목록 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			number root = new number();
			number node = root;
			String[] phoneNum = new String[N];
			
			for(int i = 0; i < N; i++) {
				phoneNum[i] = br.readLine();
			}
			
			Arrays.sort(phoneNum);
			
			boolean flag = false;
			String result = "YES";
			for(int i = 0; i < N; i++) {
				if(result.equals("NO")) {
					break;
				}
				String temp = phoneNum[i];
				
				node = root;
				for(int j = 0; j < temp.length(); j++) {
					
					int cur = temp.charAt(j) - '0';
					
					if(node.isLeaf && node.child[cur] != null) {
						result = "NO";
						break;
					}
					if(node.child[cur] == null) {
						node.child[cur] = new number();
					}
					if(j == temp.length() - 1) {
						node.isLeaf = true;
					}
					else {
						node = node.child[cur];
					}
				}
			}
			System.out.println(result);
		}
	}
}
