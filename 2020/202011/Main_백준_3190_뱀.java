package home;

import java.util.*;
import java.io.*;
 
class Main_백준_3190_뱀 {
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = {-1, 0, 1,  0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+2][N+2];
		
		Map<Integer, String> dir = new HashMap<>();
		
		// 테두리
		for(int i = 0;  i < N + 2; i++) {
			map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 1;
		}
		
		// 사과
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			
			map[r][c] = 2;
		}
		
		// 방향
		
		int L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			String c = str.nextToken();
			dir.put(x, c);
		}
        int dir_num = 1;
        int time = 0;
        Deque<Location> snake = new ArrayDeque<>();
        snake.add(new Location(1,1));
        while(true) {
            time++;
            Location head = snake.peekLast();
            int nX = head.x + dx[dir_num];
            int nY = head.y + dy[dir_num];
            if(map[nY][nX] == 1) {
                break;
            }
            if(map[nY][nX] != 2) {
                Location tail = snake.poll();
                map[tail.y][tail.x] = 0;
            }
            map[nY][nX] = 1;
            snake.addLast(new Location(nY, nX));
            if(dir.containsKey(time)) {
            	dir_num = (dir.get(time).equals("D")) ? (dir_num+1) % 4 : (dir_num+3) % 4;
            }
        }
        System.out.println(time);
    }
 
    private static class Location {
        int x;
        int y;
        Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}