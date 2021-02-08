package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			queue.add(i + 1);
		}
		System.out.print("<");
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < k - 1; j++) {
				int tmp = queue.poll();
				queue.add(tmp);
			}
			System.out.print(queue.poll() + ", ");
		}
		System.out.print(queue.poll() + ">");
	}
}
