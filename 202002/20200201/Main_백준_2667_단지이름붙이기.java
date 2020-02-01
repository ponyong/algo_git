package home;

import java.util.*;
class homes {
	int x;
	int y;
	public homes(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main_백준_2667_단지이름붙이기 {
	static int cnt = 0;
	static int home_cnt = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 길이
		char[][] map = new char[N][N];
		Queue<homes> queue = new LinkedList<>();
		boolean[][] flag = new boolean[N][N];
		
		sc.nextLine();
		
		
		for(int i = 0; i < N; i++) {
			String temp = sc.nextLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1' && flag[i][j] == false) {
					flag[i][j] = true;
					queue.add(new homes(i,j));
					
					while(!queue.isEmpty()) {
						homes temp = queue.poll();
						if(temp.x+1 < N && map[temp.x+1][temp.y] == '1' && flag[temp.x+1][temp.y] == false) {
							flag[temp.x+1][temp.y] = true;
							queue.add(new homes(temp.x+1, temp.y));
							cnt = cnt + 1;
						}
						if(temp.x-1 >= 0 && map[temp.x-1][temp.y] == '1' && flag[temp.x-1][temp.y] == false) {
							flag[temp.x-1][temp.y] = true;
							queue.add(new homes(temp.x-1, temp.y));
							cnt = cnt + 1;
						}
						if(temp.y+1 < N && map[temp.x][temp.y+1] == '1' && flag[temp.x][temp.y+1] == false) {
							flag[temp.x][temp.y+1] = true;
							queue.add(new homes(temp.x, temp.y+1));
							cnt = cnt + 1;
						}
						if(temp.y-1 >= 0 && map[temp.x][temp.y-1] == '1' && flag[temp.x][temp.y-1] == false) {
							flag[temp.x][temp.y-1] = true;
							queue.add(new homes(temp.x, temp.y-1));
							cnt = cnt + 1;
						}
					}
					list.add(cnt + 1);
					home_cnt++;
					cnt = 0;
				}
			}
		}
		Collections.sort(list);
		System.out.println(home_cnt);
		for(int i = 0; i < home_cnt; i++) {
			System.out.println(list.get(i));
		}
	}
}	
