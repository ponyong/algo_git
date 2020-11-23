package home;

import java.util.*;
import java.io.*;
import java.lang.*;
 
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];
 
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp 시작
        for(int i=N; i>0; i--) {
            int day = i + T[i];     // i번째 날의 상담기간
 
            if(day <= N+1) 
                dp[i] = Math.max(P[i] + dp[day], dp[i+1]);
            else
                // 상담일 초과
                dp[i] = dp[i+1];
        }
 
         System.out.println(dp[1]);
    }
}
