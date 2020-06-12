package home;

import java.io.FileInputStream;
import java.util.*;
public class Solution_SWEA_1266_소수완제품확률 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int len = 18; // 최대 길이
        boolean[] map = new boolean[len + 1];
         
        // 18까지의 소수 배열 구하기 
        map[0] = true;
        map[1] = true;
        for(int i = 2; i < len; i++) {
            if(map[i] == false) {
                list.add(i);
                for(int j = 2; j < len / i; j++) {
                    map[i * j] = true;
                }
            }
        }
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            double a_per = sc.nextInt();  //  A 장인의 확률
            double b_per = sc.nextInt();  //  B 장인의 확률
            double a_sum = 1; // A의 한 경우의 합
            double b_sum = 1; // B의 한 경우의 합
            double aa_sum = 0; // A의 모든 경우의 합
            double bb_sum = 0; // B의 모든 경우의 합
            double N = 18; 
            double a_cal = 1; // nCr 분자 계산
            double a_cal2 = 1; // nCr 분모 계산
     
            double b_cal = 1; // nCr 분자 계산
            double b_cal2 = 1; // nCr 분모 계산
            for(int i = 0; i < list.size(); i++) {
                // n C r 분자 
                for(int j = 0; j < list.get(i); j++ ) {
                    a_cal = a_cal * (N - j); 
                }
                // n C r 분모
                for(int j = 0; j < list.get(i); j++) {
                    a_cal2 = a_cal2 * (list.get(i) - j);
                }
                 
                // A가 소수 개의 완제품을 만든경우
                a_sum = (a_cal / a_cal2) * Math.pow((double)(a_per / 100), list.get(i)) * Math.pow((double) (100-a_per) / 100, 18- list.get(i));
                aa_sum += a_sum;
                a_sum = 1;
                a_cal = 1;
                a_cal2 = 1;
            }
            for(int i = 0; i < list.size(); i++) {
                // n C r 분자 
                for(int j = 0; j < list.get(i); j++ ) {
                    b_cal = b_cal * (N - j); 
                }
                // n C r 분모
                for(int j = 0; j < list.get(i); j++) {
                    b_cal2 = b_cal2 * (list.get(i) - j);
                }
                // B가 소수 개의 완제품을 만든 경우
                b_sum = (b_cal / b_cal2) * Math.pow((double)(b_per / 100), list.get(i)) * Math.pow((double)(100-b_per) / 100, 18- list.get(i));
                bb_sum += b_sum;
                b_sum = 1;
                b_cal = 1;
                b_cal2 = 1;
            }
            System.out.print("#" + tc + " ");
            System.out.printf("%.6f",1 - ((1 - aa_sum) *  (1- bb_sum ))); // 전체(1) -  ( 1 - A의 모든 경우의수 ) * ( 1 - B의 모든 경우의 수 )
            System.out.println();
        }
    }
}