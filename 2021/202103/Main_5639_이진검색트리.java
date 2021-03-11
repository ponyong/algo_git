package Algo_Study_BOJ;

import java.io.*;

class Node6 {
	
	int num;
	Node6 left;
	Node6 right;
	
	public Node6(int num) {
		this.num = num;
	}

	public void insert(int num) {
		if(num < this.num) {
			if(this.left == null) {
				this.left = new Node6(num);
			}
			else {
				this.left.insert(num);
			}
		}
		else {
			if(this.right == null) {
				this.right = new Node6(num);
			}
			else {
				this.right.insert(num);
			}
		}
	}
}
public class Main_5639_이진검색트리 {
	private static void postOrder(Node6 node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		Node6 root = new Node6(num);
		
		String input;
		
		while(true) {
			input = br.readLine();
			if(input == null || input.equals("")) {
				break;
			}
			root.insert(Integer.parseInt(input));
		}
		
		postOrder(root);
	}
}
