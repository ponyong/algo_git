package home;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_14502_연구소 {
	static List<int[]> list;
	static int[] data;
	static int cnt = 0;
	static int[][] map;
	static int N;
	static int M;
	static int[] dx = new int[] { 1, -1, 0 , 0 };
	static int[] dy = new int[] { 0,  0, 1 , -1};
	static int max = 0;
	public static void combination(int before ,int count) {
		if(count == 3) {
			for(int i = 0; i < 3 ; i++) {
				for(int j = i+1; j < 3; j++) {
					if(data[i] == data[j]) {
						return;
					}
				}
			}
			// 여기다 구현을 합시다.
			// 
			Queue<int[]> queue = new LinkedList<int[]>();
			int[][] map_copy = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map_copy[i][j] = map[i][j];
					if(map_copy[i][j] == 2) {
						queue.add(new int[] { i, j });
					}
				}
			}
			for(int i = 0; i <= 2; i++) {
				int[] t = list.get(data[i]);
				map_copy[t[0]][t[1]] = 1;
			}
			
			while(!queue.isEmpty()) {
				
				int[] tem = queue.poll();
				
				for(int p = 0; p < 4; p++) {
					int ni = tem[0] + dx[p];
					int nj = tem[1] + dy[p];
					
					if(ni >= 0 && ni < N && nj >= 0 && nj < M && map_copy[ni][nj] == 0) {
						map_copy[ni][nj] = 2;
						queue.add(new int[] { ni, nj });
					}
				}
			}
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map_copy[i][j] == 0) {
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
			
		}
		else {
			for(int i = before; i < list.size(); i++) {
				data[count] = i;
				combination(i, count + 1);
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken()); // N
		M = Integer.parseInt(str.nextToken()); // M
		
		map = new int[N][M];
		// 벽을 세울 수 있는 공간 (0) 을 집어 넣을 List
		list = new ArrayList<int[]>();
		for(int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int t = Integer.parseInt(temp.nextToken());
				map[i][j] = t;
				
				// 0이면 리스트에 삽입
				if(t == 0) {
					list.add(new int[] { i, j });
				}		
			}
		}
		data = new int[3];
		combination(0,0);
		System.out.println(max);
	}
}
