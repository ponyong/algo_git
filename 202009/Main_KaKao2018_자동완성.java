package home;

import java.util.*;

class Node { 
	char word;
	int count;
	Map<Character, Node> map;
	
	public Node(char n) {
		word = n;
		count = 1;
		map = new HashMap<Character, Node>();
	}
}

class Trie {
	Node head = new Node(' ');
	
	public void insert(String target) {
		Node currentHead = this.head;
		for(int i = 0; i < target.length(); i++) {
			if(currentHead.map.containsKey(target.charAt(i))) {
				currentHead.map.get(target.charAt(i)).count++;
				currentHead = currentHead.map.get(target.charAt(i));
			}
			else {
				Node temp = new Node(target.charAt(i));
				currentHead.map.put(target.charAt(i), temp);
				currentHead = currentHead.map.get(target.charAt(i));
			}
		}
	}
	public int find(String target) {
		Node currentHead = this.head;

		int result = 0;
		for(int i = 0; i < target.length(); i++) {
			result++;
			if(currentHead.map.get(target.charAt(i)).count > 1) {
				currentHead = currentHead.map.get(target.charAt(i));
			}
			else {
				return result;
			}
		}
		return result;
	}
}

public class Main_KaKao2018_자동완성 {
    public static int solution(String[] words) {
    	
    	Trie tr = new Trie();
    	for(int i = 0; i < words.length; i++) {
    		tr.insert(words[i]);
    	}
        int answer = 0;
        
        for(int i = 0; i < words.length; i++) {
        	answer += tr.find(words[i]);
        }
        return answer;
    }
	public static void main(String[] args) {
		String[] tmp = { "go", "gone", "guild" };
		
		System.out.println(solution(tmp));
	}
}
