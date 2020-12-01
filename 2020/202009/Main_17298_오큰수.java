package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(0);
		
		for(int i = 1; i < N; i++) {
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				result[st.pop()] = arr[i];
			}
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			result[st.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}
}
