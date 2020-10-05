package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_KaKao2018_캐시 {
    public static int solution(int cacheSize, String[] cities) {
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        int answer = 0;
        String city = "";
        
        List<String> cache = new LinkedList<String>();
        
        for(int i = 0; i < cities.length; i++) {
            city = cities[i].toUpperCase();
            
            if(cache.contains(city)) {
                
                cache.remove(city);
                cache.add(city);
                answer++;
                
            } else if(cache.size() < cacheSize) {
                
                cache.add(city);
                answer += 5;
                
            } else {
                if(cacheSize > 0) {
                    cache.remove(0);
                    cache.add(city);
                }
                answer += 5;
            }
        }
        return answer;
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str = new StringTokenizer(br.readLine());
		
		String s = str.nextToken();
		int a = 0;
		String[] ss = null;
		System.out.println(solution(a, ss));
	}
}
