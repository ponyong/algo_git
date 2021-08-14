package home;

import java.util.*;
import java.io.*;
  
class Main_백준_13458_시험감독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) 
            a[i] = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
 
        /**
         * 계산 시작
         * total 은 long으로 선언한다.
         */
        long total = n;
        for(int i=0; i<n; i++) {
            // 총감독관은 무조건 한명씩 필요
            a[i] -= b;
 
            // 부감독관으로 나머지 채우기
            if(a[i] > 0) {
                total += a[i]/c;
 
                if(a[i] % c != 0)
                    total++;
            }
        }
 
        System.out.println(total);
    }
}