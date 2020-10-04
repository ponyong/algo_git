package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_KaKao2018_뉴스클러스터링 {
	
	private static double jaka(List<String> list1, List<String> list2) {
		
		int sumCount = 0;
		int crossCount = 0;
		boolean flag = false;
		for(int i = 0; i < list1.size(); i++) {
			flag = false;
			for(int j = 0; j < list2.size(); j++) {
				if(list1.get(i).equals(list2.get(j))) {
					sumCount++;
					crossCount++;
					list2.remove(j);
					flag = true;
					break;
				}
			}
			if(!flag) {
				sumCount++;
			}
		}
		sumCount += list2.size();
		return (double)crossCount / sumCount;
	}
	public static List<String> changeString(String str) {
		
		List<String> temp = new LinkedList<String>();
	
		for(int i = 0; i < str.length() - 1; i++) {
			String tmp = "";
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90 && str.charAt(i+1) >= 65 && str.charAt(i+1) <= 90) {
				tmp += str.charAt(i);
				tmp += str.charAt(i+1);
				temp.add(tmp);
			}
			else {
				continue;
			}
		}
		return temp;
	}

    public static int solution(String str1, String str2) {
    	
    	List<String> list1 = new LinkedList<String>();
    	List<String> list2 = new LinkedList<String>();
    	list1 = changeString(str1.toUpperCase());
    	list2 = changeString(str2.toUpperCase());
    	
    	if(list1.size() == 0 && list2.size() == 0) {
    		return 65536;
    	}
    	double cnt;
    	cnt = jaka(list1, list2);

    	int answer = (int) (cnt * 65536);
        return answer;
    }

	public static void main(String[] args) throws Exception {

		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";

		System.out.println(solution(str1,str2));
	}
}
