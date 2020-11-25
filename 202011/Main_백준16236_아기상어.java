package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준16236_아기상어 {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int shark_size;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 맵 크기

		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];

		Queue<int[]> queue = new LinkedList<>();
		shark_size = 2;
		int shark_i = 0;
		int shark_j = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
				// 상어 위치 넣으면서 찾아서 큐에 넣기
				if (map[i][j] == 9) {
					queue.add(new int[] { i, j , 0});
					visit[i][j] = true;
					shark_i = i;
					shark_j = j;
				}
			}
		}
		int sum = 0;
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		// 전 맵에서 가장 작은값을 체크
		for (int k = 0; k < N; k++) {
			for (int l = 0; l < N; l++) {
				sum += map[k][l]; // 모두 더한값이 9라면 다먹은거
				if(map[k][l] != 0) {
					min = Math.min(min, map[k][l]);
					
				}
			}
		}
		// 상어만 있거나 ( sum == 9 ) || 가장 작은값이 상어보다 큰경우 
		if (sum == 9 || min >= shark_size) {
			System.out.println(cnt);
			return;
		}
		// 상어가 4방 탐색을 하면서 0이 아닌 값을 만나면 먹을 수 있는지 체크하고 있으면 그 위치로 이동하면서 거리계산
		int eat_cnt = 0;
		boolean flag = false;
		int[] target = new int[3];
		Queue<int[]> t_queue = new LinkedList<int[]>();
		while (!queue.isEmpty()) {
			min = Integer.MAX_VALUE;
			for (int k = 0; k < N; k++) {
				for (int l = 0; l < N; l++) {
					sum += map[k][l]; // 모두 더한값이 9라면 다먹은거
					if(map[k][l] != 0) {
						min = Math.min(min, map[k][l]);
					}
				}
			}
			if (sum == 9 || min >= shark_size) {
				System.out.println(cnt);
				return;
			}
			int size=queue.size();
			for (int mm = 0; mm < size; mm++) {
				int[] tmp=queue.poll();
				for(int m=0;m<4;m++) {
 					int ni = tmp[0] + dx[m];
					int nj = tmp[1] + dy[m];
					if (ni >= 0 && nj >= 0 && ni < N && nj < N && !visit[ni][nj] && map[ni][nj] <= shark_size) {
						visit[ni][nj] = true;
						if(map[ni][nj]<shark_size && map[ni][nj] != 0) {//먹을수 이써!
							flag=true;
							t_queue.add(new int[] {ni,nj , tmp[2] + 1});
						}else queue.add(new int[] { ni, nj ,tmp[2] + 1});
					}
				}
			}

			if(flag) {
				int[] first = t_queue.poll(); // 첫물고기
				for (int l = 0; l < t_queue.size(); l++) {
					int[] tm = t_queue.poll();

					if (tm[0] == first[0]) {
						if (tm[1] < first[1]) {
							first[1] = tm[1];
						}
					}
					if (first[0] > tm[0]) {
						first[0] = tm[0];
						first[1] = tm[1];
					}
				}
				map[shark_i][shark_j] = 0;
				shark_i = first[0];
				shark_j = first[1];
				map[shark_i][shark_j] = 9;
				queue.clear();
				t_queue.clear();
				visit = new boolean[N][N];
				cnt += first[2];
				eat_cnt++;
				if (eat_cnt == shark_size) {
					if(shark_size <= 7) {
						shark_size++;
					}
					eat_cnt = 0;
				}
				queue.add(new int[] { first[0], first[1], 0 });
				flag = false;

				continue;
			}
		
		}
		System.out.println(cnt);
	}
}