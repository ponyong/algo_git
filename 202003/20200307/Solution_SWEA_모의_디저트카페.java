package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_SWEA_모의_디저트카페 {
    public static int[] dx = { 1, 1, -1 , -1};
    public static int[] dy = { 1, -1,-1 ,  1};
    public static int[][] map;
    public static boolean[] visit;
    public static int N;
    public static int st_x, st_y;
    public static int max = -1;
    public static void dfs(int x, int y, int count , int dir) {
         
        if(count > 3 && st_x == x && st_y == y) {
            max = Math.max(max, count);
            return;
        }
        if(!visit[map[x][y]]) {
            visit[map[x][y]] = true;
            for(int t = dir; t < 4; t++) {
                 
                int ni = x + dx[t];
                int nj = y + dy[t];
                 
                if(ni >= 0 && ni < N && nj >= 0 && nj < N) {
                    dfs(ni, nj , count + 1, t);
                }
            }
        visit[map[x][y]] = false;
        }
    }
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine()); // 10
         
        for(int tc = 1; tc <= T; tc++) {
             
            N = Integer.parseInt(br.readLine().trim()); // 4
             
            map = new int[N][N];
            visit = new boolean[101];
            for(int i = 0; i < N; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            int n = 0;
            if(N % 2 == 0) {
                n = N / 2;
            }
            else {
                n = N / 2 + 1;
            }
            for(int i = 0; i < n; i++) {
                for(int j = 1; j < N-1; j++) {
                    st_x = i;
                    st_y = j;
                    visit = new boolean[101];
                    dfs(i, j , 0, 0);
//                  System.out.print(map[i][j] + " ");
                }
//              System.out.println();
            }
 
            System.out.println("#" + tc + " " + max);
            max = -1;
        }
    }
}