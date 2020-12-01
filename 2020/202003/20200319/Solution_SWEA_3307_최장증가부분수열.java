package home;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_SWEA_3307_최장증가부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine()); // Testcase_ 수
        for(int test_case = 1; test_case <= T; test_case++) {
            int len = Integer.parseInt(br.readLine()); // 수열의 길이
            String[] temp = br.readLine().split(" "); // 수열  1 3 2 5 4  #1 3
            int[] max_len = new int[len];
             
            for(int i = 0; i < temp.length; i++) {
                int cur_maxlen = 0; // 
                for(int j = 0; j < i; j++) {
                    if(Integer.parseInt(temp[j]) < Integer.parseInt(temp[i])) {
                        cur_maxlen = Math.max(max_len[j], cur_maxlen);
                    }
                }
                cur_maxlen++;
                max_len[i] = cur_maxlen;
            }
            int max = max_len[0];
            System.out.print("#" + test_case + " ");
            for(int i = 1; i < temp.length; i++) {
                if(max < max_len[i]) {
                    max = max_len[i];
                }
            }
            System.out.println(max);
        }
         
    }
}