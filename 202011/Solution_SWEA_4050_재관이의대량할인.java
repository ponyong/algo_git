package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_SWEA_4050_재관이의대량할인 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine()); // tc
         
        for(int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(br.readLine()); // 옷 개수
            int num = N / 3; // 3개씩 나눌 수 있는 수
             
            List<Integer> list = new ArrayList<>();
             
            StringTokenizer temp = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                list.add(Integer.parseInt(temp.nextToken()));
            }
             
            Collections.sort(list, Collections.reverseOrder());
 
            int sum = 0;
            for(int i = 0; i < list.size(); i++) {
                if(i % 3 != 2) {
                    sum += list.get(i);
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
         
    }
}