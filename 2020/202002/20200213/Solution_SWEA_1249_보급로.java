package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;
public class Solution_SWEA_1249_보급로 {
    public static int[] dx = {  -1, 1, 0 , 0};
    public static int[] dy = {  0 , 0 ,-1, 1};
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine()); // Testcase
         
        for(int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
             
            int[][] map = new int[N][N];
            boolean[][] visit = new boolean[N][N];
            int[][] check = new int[N][N];
            for(int i = 0; i < N; i++) {
                String temp = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j) - '0';
                }
            }
             
            Queue<int[]> queue = new LinkedList<>();
             
            queue.add(new int [] { 0, 0 , 0 }); // 제일 왼쪽위 시작값
         
            while(!queue.isEmpty()) {
                int[] t = queue.poll();
 
                for(int i = 0; i < 4; i++) {
                     
                    int ni = t[0] + dx[i];
                    int nj = t[1] + dy[i];
                     
                    if(ni >= 0 && ni < N && nj >= 0 && nj < N)
                        if(!visit[ni][nj]) {
                            check[ni][nj] = t[2] + map[ni][nj];
                            visit[ni][nj] = true;
                            queue.add(new int[] { ni, nj , check[ni][nj]});
                        }
                        else if(map[ni][nj] + t[2] < check[ni][nj]) {
                            check[ni][nj] = t[2] + map[ni][nj];
                            queue.add(new int[] { ni, nj , check[ni][nj]});
                        }
                    }
                }
            System.out.println("#" + tc + " " + check[N-1][N-1]);
            }
        }
}