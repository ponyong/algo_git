package com.ssafy;

public class Node {
	int vertex;
	int weight;
	Node next;
	
	public Node(int vertex, int weight, Node next) {
		super();
		this.vertex = vertex;
		this.weight = weight;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
	}
	
	
	
}
