package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_SWEA_모의_활주로건설 {
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(str.nextToken()); // MAP 크기
            int L = Integer.parseInt(str.nextToken()); // 경사로 길이
             
            int[][] map = new int[N][N];
            int ans = 0;
             
            for(int i = 0; i < N; i++) {
                StringTokenizer temp = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(temp.nextToken());
                }
            }
            int j = 0;
            for(int i = 0; i < N; i++) {
                int cnt = 1;
                for(j = 0; j < N-1; j++) {
                    if(map[i][j] == map[i][j+1]) cnt++;
                    else if(map[i][j] + 1 == map[i][j+1] && cnt >= L) cnt = 1;
                    else if(map[i][j] - 1 == map[i][j+1] && cnt >= 0) cnt = -L+1;
                    else break;
                }
                if(j == N-1 && cnt >= 0) ans++;
                 
                cnt = 1;
                for(j = 0; j < N-1; j++) {
                    if(map[j][i] == map[j+1][i]) cnt++;
                    else if(map[j][i] + 1 == map[j+1][i] && cnt >= L) cnt = 1;
                    else if(map[j][i] - 1 == map[j+1][i] && cnt >= 0) cnt = -L+1;
                    else break;
                }
                if(j == N-1 && cnt >= 0) ans++;
            }
         
        System.out.println("#" + tc + " " + ans);
        }
    }
}