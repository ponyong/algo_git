package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17299_오등큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		int[] time = new int[count];
		int[] freq = new int[1000001];
		
		String[] line = br.readLine().split(" ");
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < count; i++) {
			freq[Integer.parseInt(line[i])]++;
		}
		
		st.add(0);
		
		for(int i = 1; i < count; i++) {
			while(!st.isEmpty() && freq[Integer.parseInt(line[st.peek()])] < freq[Integer.parseInt(line[i])]) {
				time[st.pop()] = Integer.parseInt(line[i]);
			}
			st.add(i);
		}
		while(!st.isEmpty()) {
			time[st.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < time.length; i++) {
			sb.append(time[i] + " ");
		}
		System.out.print(sb);
	}
}
