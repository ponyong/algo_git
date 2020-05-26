package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_SWEA_4672_수진이의팰린드롬 {
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            char[] temp = br.readLine().toCharArray();
             
            int[] alpa = new int[26]; // 알파벳 개수 만큼
             
            for(int i = 0; i < temp.length; i++) {
                alpa[(temp[i] - 97)]++; 
            }
            int sum = 0;
            for(int i = 0; i < alpa.length; i++) {
                if(alpa[i] != 0) {
                    for(int j = alpa[i]; j > 0; j--) {
                        sum += j;
                    }
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}