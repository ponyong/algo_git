package train;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_백준_1600_말이되고싶은원숭이 {

	public static int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2, 1, -1, 0, 0 };
	public static int[] dy = { 2, 2, 1, -1, -2, -2, -1, 1, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int horse = Integer.parseInt(br.readLine()); // 말 뛰기 횟수

		StringTokenizer str = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());

		int[][] map = new int[N][M];
		boolean[][][] visit = new boolean[31][N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0, horse, 0 });
		visit[horse][0][0] = true;
		int sol = -1;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if (tmp[0] == N - 1 && tmp[1] == M - 1) {
				sol = tmp[3];
				break;
			}
			int k = 0;
			if (tmp[2] > 0) {
				k = 0;
			} else {
				k = 8;
			}

			for (int i = k; i < dx.length; i++) {
				int ni = tmp[0] + dx[i];
				int nj = tmp[1] + dy[i];

				if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 0) {
					if (i >= 8) {
                       if(!visit[tmp[2]][ni][nj]) {
                            visit[tmp[2]][ni][nj] = true;
						    queue.add(new int[] { ni, nj, tmp[2], tmp[3] + 1 });
                        }
					} else {
                       if(!visit[tmp[2]-1][ni][nj]) {
                            visit[tmp[2]-1][ni][nj] = true;
						    queue.add(new int[] { ni, nj, tmp[2] - 1, tmp[3] + 1 });
                        }
					}
				}
			}
		}
		System.out.println(sol);
	}
}
