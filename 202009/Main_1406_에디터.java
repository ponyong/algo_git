package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1406_에디터 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String base = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack lStack = new Stack<>();
		Stack rStack = new Stack<>();
		
		for(int i = 0; i < base.length(); i++) {
			lStack.add(base.charAt(i));
		}
		
		for(int i = 0; i < N; i++) {
			String in = br.readLine();
			
			if(in.equals("L")) {
				if(!lStack.isEmpty()) {
					rStack.add(lStack.pop());
				}
			}
			else if(in.equals("D")) {
				if(!rStack.isEmpty()) {
					lStack.add(rStack.pop());
				}
			}
			else if(in.equals("B")) {
				if(!lStack.isEmpty()) {
					lStack.pop();
				}
			}
			else if(in.charAt(0) == 'P') {
				lStack.add(in.charAt(2));
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!lStack.isEmpty()) {
			rStack.add(lStack.pop());
		}
		while(!rStack.isEmpty()) {
			sb.append(rStack.pop());
		}
		System.out.println(sb);
	}
}
