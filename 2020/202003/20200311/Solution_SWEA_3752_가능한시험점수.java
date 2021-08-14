package home;

import java.io.FileInputStream;
import java.util.*;
 
public class Solution_SWEA_3752_가능한시험점수 {
    public static void main(String[] args) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // test_case 수
        for(int tc = 1;  tc <= T; tc++) {
            boolean[] find = new boolean[10001];
            int num_cnt = sc.nextInt(); // 숫자 개수
            find[0] = true;
            for(int i = 0; i < num_cnt; i++) {
                int cur_num = sc.nextInt(); // 현재 숫자
                for(int j = find.length - 1; j >= 0; j--) {
                    if(find[j] == true) {  
                        find[j + cur_num] = true;
                    }
                }
            }
            int cnt = 0;
            for(int i = 0; i < find.length; i++) {
                if(find[i] == true) {
                    cnt++;
                }
            }       
            System.out.print("#" + tc + " " + cnt);
            System.out.println();
        }
    }
}