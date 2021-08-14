package home;

import java.util.*;
import java.io.*;
 
class Main_백준_3190_뱀 {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static class Dot {
        int x, y;
        
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    static int n;
    static int K;
    static int[][] map;
    static int L;
    static int[] time;
    static int[] dir;
    static int[] dx = {-1, 0, 1, 0};    // 북동남서
    static int[] dy = {0, 1, 0, -1};
    static Deque<Dot> snake = new ArrayDeque<Dot>();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = stoi(br.readLine());
        K = stoi(br.readLine());
        map = new int[n+1][n+1];    // 맨 위 맨 좌측은 (1,1)
 
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
 
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());
            map[v1][v2] = 1;    // 사과 위치는 1
        }
 
        L = stoi(br.readLine());
        time = new int[L];
        dir = new int[L];
 
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
 
            time[i] = stoi(st.nextToken());
            dir[i] = getDirection(st.nextToken());
        }
 
        // 문제 풀이
        solution();
    }
 
    static void solution() {
        int second = 0;
        int snakeDir = 1;    // 첫 방향은 오른쪽
        int timeIdx = 0;
        map[1][1] = 2;  // 처음 뱀의 위치는 (1,1)
        snake.add(new Dot(1, 1));
 
        while(true) {
            // 시간이 지나면 방향 바꾸기
            if(timeIdx < L && time[timeIdx] == second) {
                snakeDir = (snakeDir + dir[timeIdx])%4;
                timeIdx++;
            }
 
            // 1. 몸길이를 늘려 머리를 다음 칸에 위치시킨다
            int nx = snake.getFirst().x + dx[snakeDir];
            int ny = snake.getFirst().y + dy[snakeDir];
 
            // 몸이나 벽과 부딪히면 게임 끝
            if(nx <= 0 || nx > n || ny <= 0 || ny > n) {
                System.out.println(second + 1);
                break;
            }
            if(map[nx][ny] == 2) {
                System.out.println(second + 1);
                break;
            }        
 
            // 2. 만약 이동한 칸에 사과가 있다면, 사과 없어지고 꼬리 그대로 머리 추가
            if(map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake.addFirst(new Dot(nx, ny));
            }
            // 3. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여 꼬리가 위치한 칸 비우기
            else if(map[nx][ny] == 0) {
                map[nx][ny] = 2;
                snake.addFirst(new Dot(nx, ny));
 
                Dot tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
 
            second++;
        }
    }
    
    // 오른쪽은 1 왼쪽은 3
    static int getDirection(String s) {
        if(s.equals("D")) 
            return 1;
        else
            return 3;
    }
}
