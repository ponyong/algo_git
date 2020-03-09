package home;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class Solution_SWEA_3074_입국심사 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int[] tk = new int[N];
            long max = 0;
            for(int i = 0; i < N; i++) {
                int time = sc.nextInt();
                tk[i] = time;
                max = max<time?time:max;
            }
            long left = 1;
            long right = max*M;
            long mid = 0;
            while(left<right) {
                mid = (left+right)/2;
                long mid_total = 0;
                for(int i = 0; i < N; i++) mid_total += (mid/tk[i]);
                 
//              if(mid_total==M) break;
                if(mid_total >= M) right = mid;
                else left = mid+1;
            }
             
//          mid = (left+right)/2;
//          sb.append("#" + tc + " " + 1 + "\n");
            System.out.println("#" + tc + " " + left);
        }
        System.out.println(sb.toString());
    }
}