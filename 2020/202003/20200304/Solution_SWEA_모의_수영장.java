package home;

import java.io.IOException;
import java.util.Scanner;
  
public class Solution_SWEA_모의_수영장 {
    static int n;
    static int[] pay,month;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 1; i <= tc; i++) {
            pay = new int[4];
            month = new int[12];
            for(int j = 0; j < 4; j++)
                pay[j] = sc.nextInt();
            for(int j = 0; j < 12; j++)
                month[j] = sc.nextInt();
            result = Integer.MAX_VALUE;
            solve(0,0);
            System.out.println("#"+i+" "+result);
        }
    }
    // 1일, 1달, 3달, 1년
    private static int result;
    private static void solve(int idx,int sum) {
        if(idx >= 12) {
            result = Math.min(result, sum);
            return;
        }
         
        // 1일
        solve(idx+1,sum+(month[idx]*pay[0]));
        // 1달
        if(month[idx]>0)
            solve(idx +1 ,sum+pay[1]);
        // 3달
        if(idx<=9) {
            if(month[idx]+month[idx+1]+month[idx+2]>0)
                solve(idx+3,sum+pay[2]);
        }
        // 1년
        if(idx==0)
            solve(idx+12,sum+pay[3]);
    }
}