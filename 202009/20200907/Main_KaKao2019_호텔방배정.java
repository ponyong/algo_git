package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_KaKao2019_호텔방배정 {
	public static Map<Long, Long> map = new HashMap<>();
	
	public static long find(long temp) {
		if(!map.containsKey(temp)) {
			map.put(temp, temp + 1);
			
			return temp;
		}
			
		map.put(temp, find(map.get(temp)));
		
		return map.get(temp);
	}
	public static List<Long> solution(long k, long[] list) {
		
		List<Long> answer = new LinkedList<Long>();
		for(int i = 0; i < list.length; i++) {
			
			long temp = list[i];
			
			answer.add(find(temp));
		}
		return answer;
	}
	public static void main(String[] args) {
		long[] list = new long[] { 1, 3, 4, 1,3 ,1 };		
		System.out.println(solution(10, list));
	}

}
