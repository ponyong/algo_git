package home;

import java.util.Scanner;
import java.util.*;
public class Solution_SWEA_2806_NQUEEN {
    public static int N;
    public static int[] col;
    public static int result;
 
    public static boolean promising(int i) {
        for(int j = 0; j < i; j++) {
            if(col[j]== col[i] || Math.abs(col[i]- col[j]) == (i-j)) return false;
        }
        return true;
    }
     
    public static void nqueen(int i,String s) {
        if(i == N ) {
            result = result + 1;
        }
        else {
            for(int j = 0; j <N; j++) {
                col[i] = j;
                if(promising(i)) {
                    nqueen(i+1,s+ i+","+col[i]+" ");
                }
            }
        }
    }
     
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            result=0;
            N=sc.nextInt();
            col=new int[N];
            nqueen(0,"");
            System.out.println("#"+tc+" "+result);
        }
        sc.close();
    }
}