package home;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_SWEA_1868_������������ã�� {
    public static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    public static int[] dy = { 1, 1, 1, 0, -1, -1, -1, 0 };
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine()); // tc
 
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // map ũ��
 
            char[][] map = new char[N][N];
            boolean[][] visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
 
            Queue<int[]> queue = new LinkedList<>();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visit[i][j]) {
                        int star_cnt = 0;
                        // . �̸� ���� 8�� Ž���� ��.
                        for (int k = 0; k < 8; k++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
 
                            if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
                                if (map[ni][nj] == '*') {
                                    star_cnt++;
                                }
                            }
                        }
                        // 8���� ���Ҵµ� ���� 0�� ( star_cnt = 0) �̸�
                        if (star_cnt == 0) {
                            // ��Ʈ�� �� �ִ� best place
                            visit[i][j] = true;
                            queue.add(new int[] { i, j });
                            for (int k = 0; k < 8; k++) {
                                int ni = i + dx[k];
                                int nj = j + dy[k];
 
                                if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
                                    visit[ni][nj] = true;
                                }
                            }
                        }
                    }
                }
            }
            // ��Ʈ�� �� �ִ� ��ǥ�� ��� �켱��Ʈ����
            Queue<int[]> subQ = new LinkedList<int[]>();
            while (!queue.isEmpty()) {// Best
                int[] temp = queue.poll();
                if (map[temp[0]][temp[1]] == '.') {
                    map[temp[0]][temp[1]] = '0';
                    cnt++;
                    for (int k = 0; k < 8; k++) {
                            int ni = temp[0] + dx[k];
                            int nj = temp[1] + dy[k];
                            if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
                                map[ni][nj] = '0';
                                subQ.add(new int[] {ni,nj});
                            }
                        }
                    while (!subQ.isEmpty()) {// ����Ʈ ������ �����ڿ� ���������� ȿ���� ����
                        int[] p = subQ.poll();
                        int count=0;
                        for (int k = 0; k < 8; k++) {
                            int ni = p[0] + dx[k];
                            int nj = p[1] + dy[k];
                            if (ni >= 0 && nj >= 0 && ni < N && nj < N&&map[ni][nj]=='*') {
                                count++;
                            }
                        }
                        if(count==0) {
                            for (int k = 0; k < 8; k++) {
                                int ni = p[0] + dx[k];
                                int nj = p[1] + dy[k];
                                if (ni >= 0 && nj >= 0 && ni < N && nj < N&&map[ni][nj]=='.') {
                                    map[ni][nj]='0';
                                    subQ.add(new int[] {ni,nj});
                                }
                            }
                        }
                         
                    }
                }
 
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}