package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_4613_러시아국기같은깃발{
    public static char[][] map;
    public static int[] res;
    public static int N, M;
    public static int min;
 
    public static void comb(int sta, int count) {
 
        if (count == 2) {
            int cnt = 0;
            for (int i = 0; i < res[0]; i++) {
                for (int l = 0; l < M; l++) {
                    if (map[i][l] != 'W') {
                        cnt++;
                    }
                }
            }
            for (int j = res[0]; j < res[1]; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] != 'B') {
                        cnt++;
                    }
                }
            }
            for (int k = res[1]; k < N; k++) {
                for (int m = 0; m < M; m++) {
                    if (map[k][m] != 'R') {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
            cnt = 0;
            return;
        }
        for(int i = sta + 1;i < N;i++) {
            res[count] = i;
            comb(i, count + 1);
        }
    }
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
         int T = Integer.parseInt(br.readLine()); //tc
         for(int tc = 1; tc <= T; tc++) {
             min = Integer.MAX_VALUE;
              
             StringTokenizer str = new StringTokenizer(br.readLine());
              
             N = Integer.parseInt(str.nextToken());
             M = Integer.parseInt(str.nextToken());
              
             map = new char[N][M];
             res = new int[2];
             for(int i = 0; i < N; i++) {
                 String s = br.readLine();
                 for(int j = 0; j < M; j++) {
                     map[i][j] = s.charAt(j);
                 }
             }
             comb(0,0);
             System.out.println("#" + tc + " " + min);
         }
    }
}