package home;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_SWEA_모의_홈방범서비스 {
    public static int cal_money(int n) {
        return (n * n) + ((n-1) * (n-1));
    }
    public static int[] dx = { 1, -1 , 0 , 0 };
    public static int[] dy = { 0,  0 ,-1 , 1 };
    public static int maxhousecount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine()); //tc
         
        for(int tc = 1; tc <= T; tc++) {
             
            StringTokenizer str = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(str.nextToken()); // 맵 크기
            int M = Integer.parseInt(str.nextToken()); // 한 집이 제공할 수 있는 값
             
            int[][] map = new int[N][N];
             
            for(int i = 0; i < N; i++) {
                StringTokenizer temp = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(temp.nextToken());
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visit;  
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                        visit = new boolean[N][N];
                        queue.add(new int[] {i, j});
                         
                        visit[i][j] = true;
                        int cnt = map[i][j];
                        while(!queue.isEmpty()) {
                             
                            for(int dep = 1; dep < 2 * N; dep++) {
                                 
                                int price = (M * cnt) - cal_money(dep);
                                 
                                if(price >= 0 && maxhousecount < cnt) {
                                     
                                    maxhousecount = cnt;
                                }
                                int qSize = queue.size();
                                while(qSize-- > 0) {
                                    int[] tmp = queue.poll();
                                     
                                    for(int k = 0; k < 4; k++) {
                                        int ni = tmp[0] + dx[k];
                                        int nj = tmp[1] + dy[k];
                                         
                                        if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visit[ni][nj]) {
                                            visit[ni][nj] = true;
                                            queue.add(new int[] {ni, nj});
                                             
                                            if(map[ni][nj] == 1) {
                                                cnt++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            System.out.println("#" + tc + " " + maxhousecount);
            maxhousecount = 0;
        }
    }
}