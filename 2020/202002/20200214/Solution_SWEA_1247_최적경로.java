package home;

import java.io.*;
import java.util.*;
 
class home {
    public home(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
}
public class Solution_SWEA_1247_최적경로 {
    static int N;
    static int M;
    static int min_distance = Integer.MAX_VALUE;
    static boolean[] visit = new boolean[11];
    static home[] arr;
    static home[] sol;
     
    public static void permutation(int lev) {
        // 만약에 다 뽑았으면
        if(lev == M) {
            int sum = 0;
            for (int i = 0; i <= M; i++) {
                sum += Math.abs(sol[i].x - sol[i+1].x) + Math.abs(sol[i].y - sol[i+1].y);
//              System.out.print(sol[i].x + "," + sol[i].y + " " + sum);
            }
            min_distance = Math.min(min_distance, sum);
            return;
        }
         
        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                sol[lev+1] = arr[i];
                visit[i] = true;
                 
                permutation(lev + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 방문해야 하는 고객 수 
            M = N;
            arr = new home[N+2];
            sol = new home[N+2];
            arr[0] = new home(sc.nextInt(), sc.nextInt()); // 집
            arr[N+1] = new home(sc.nextInt(), sc.nextInt()); // 회사
            sol[0] = arr[0];
            sol[N+1] = arr[N+1];
            for(int i = 0; i < N; i++) {
                arr[i+1] = new home(sc.nextInt(), sc.nextInt());
            }
            permutation(0);
            System.out.print("#" + tc + " ");
            System.out.println(min_distance);
            min_distance = Integer.MAX_VALUE;
        }
    }
}