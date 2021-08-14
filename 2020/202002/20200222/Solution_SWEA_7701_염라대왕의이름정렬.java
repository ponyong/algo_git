package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution_SWEA_7701_염라대왕의이름정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
         
        for(int tc = 1; tc <= T; tc++) {
            Set<String> st = new TreeSet<>(new Comparator<String>() {
                 
                @Override
                public int compare(String s1, String s2) {
                    if (s1.length() == s2.length())
                        return s1.compareTo(s2);
                    else if (s1.length() < s2.length())
                        return -1;
                    else
                        return 1;
                }
                 
            });
            int C  = Integer.parseInt(br.readLine()); // 단어 개수
             
             
            for(int i = 0; i < C; i++) {
                 
                st.add(br.readLine());
            }
             
            Iterator<String> it = st.iterator();
            System.out.println("#" + tc);
            while(it.hasNext()) {
                System.out.println(it.next());
            }
 
              
        }
    }
}