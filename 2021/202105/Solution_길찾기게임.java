package Algo_Study_Programmers;

import java.util.*;

class NodeInfo implements Comparable<NodeInfo>{

	int num;
	int x;
	int y;
	
	NodeInfo left;
	NodeInfo right;

	public NodeInfo(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(NodeInfo o) {
		return o.y - this.y;
	}
}
public class Solution_길찾기게임 {
	static List<NodeInfo> list;
	static int idx;
	private static void find(NodeInfo parent, NodeInfo child) {
		if(parent.x > child.x) {
			if(parent.left == null) {
				parent.left = child;
			}
			else {
				find(parent.left, child);
			}
		}
		else {
			if(parent.right == null) {
				parent.right = child;
			}
			else {
				find(parent.right, child);
			}
		}
	}
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        list = new ArrayList<NodeInfo>();
        
        for(int i = 0; i < nodeinfo.length; i++) {
        	list.add(new NodeInfo(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(list);
        
        NodeInfo root = list.get(0);
        
        for(int i = 1; i < list.size(); i++) {
        	NodeInfo child = list.get(i);
        	find(root, child);
        }
        
        int[][] arr = new int[2][list.size()];
        idx = 0;
        preOrder(arr, root);
        
        idx = 0;
        postOrder(arr, root);
        return answer;
    }
    private static void preOrder(int[][] arr, NodeInfo node) {
    	// 나 왼 오
    	if(node != null) {
    		arr[0][idx++] = node.num;
    		if(node.left != null) {
    			preOrder(arr, node.left);    			
    		}
    		if(node.right != null) {
    			preOrder(arr, node.right);
    		}
    	}
    }
	private static void postOrder(int[][] arr, NodeInfo node) {
		// 왼 오 나 
		if(node != null) {
			if(node.left != null) {
				postOrder(arr, node.left);
			}
			if(node.right != null) {
				postOrder(arr, node.right);
			}
			arr[1][idx++] = node.num; 
		}
	}
	public static void main(String[] args) {
		int[][] nodeinfo = new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(nodeinfo);
	}
}
