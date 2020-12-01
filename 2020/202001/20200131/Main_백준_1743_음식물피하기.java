package home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1743_음식물피하기 {
    static int N, M, K, table[][];
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        table = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];
        while (K-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            table[x][y] = 1;
        }
        int result = 0;
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=M; j++) {
                if (!check[i][j]&&(table[i][j]==1)) {
                    result = Math.max(result,proc(i, j));
                }
            }
        }
        System.out.println(result);
    }

    public static int proc(int x, int y) {
        if (x < 1 || y < 1 || x > N || y > M) return 0;
        if (check[x][y]) return 0 ;

        if (!((table[x][y] == 1) && !check[x][y])) return 0;
        int dx[] = new int[]{-1,0 , 1, 0};
        int dy[] = new int[]{0, -1, 0, 1};
        check[x][y] = true;
        int result =1;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            result += proc(next_x, next_y);
        }

        return result;
    }
}
