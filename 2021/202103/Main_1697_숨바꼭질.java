package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main_1697_숨바꼭질 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(str.nextToken());
		int end = Integer.parseInt(str.nextToken());
		boolean[] visit = new boolean[100003];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[]{ start, 0 });
		
		while(!queue.isEmpty()) {
			
			int temp[] = queue.poll();
			
			if(temp[0] == end) {
				System.out.println(temp[1]);
				break;
			}
			if(temp[0] - 1 >= 0 && !visit[temp[0] - 1]) {
				visit[temp[0] - 1] = true;
				queue.add(new int[] {temp[0]  - 1 , temp[1] + 1}); 
			}
			if(temp[0] + 1 <= 100002 && !visit[temp[0] + 1]) {
				visit[temp[0] + 1] = true;
				queue.add(new int[] {temp[0]  + 1 , temp[1] + 1}); 
			}
			if(temp[0] * 2 <= 100002 && !visit[temp[0] * 2]) {
				visit[temp[0] * 2] = true;
				queue.add(new int[] {temp[0] * 2 , temp[1] + 1}); 
			}
		}
	}
}
