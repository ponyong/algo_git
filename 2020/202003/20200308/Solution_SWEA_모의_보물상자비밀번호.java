package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.*;
 
public class Solution_SWEA_모의_보물상자비밀번호 {
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
             
            List<Long> list = new ArrayList<>();
            StringTokenizer str = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(str.nextToken()); // 숫자 개수
            int K = Integer.parseInt(str.nextToken()); // K 번째 숫자
             
            String st = br.readLine(); // 줄
            String temp = st + st.substring(0, (N / 4) - 1);
                 
            for(int i = 0; i < N; i++) {
                int t = (N / 4);
                long v = Long.parseLong(temp.substring(i, i + t),16);
                if(!list.contains(v)) {
                    list.add(v);
                }
            }
            Collections.sort(list);
            Collections.reverse(list);
            System.out.println("#" + tc + " " + list.get(K - 1));
        }
    }
}