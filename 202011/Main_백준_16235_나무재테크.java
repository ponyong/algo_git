package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Grow {
	int start_num;
	int grow_num;
	public Grow(int start_num, int grow_num) {
		this.start_num = start_num;
		this.grow_num = grow_num;
	}

	
}
public class Main_백준_16235_나무재테크 {
	static int[] dx = {-1, -1, -1, 0 , 0, 1, 1, 1 };
	static int[] dy = {-1, 0 , 1, -1 , 1, -1,0, 1 };
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 맵 크기 
		
		int M = Integer.parseInt(str.nextToken()); // 나무개수 
		
		int K = Integer.parseInt(str.nextToken()); // 년 수 
		
		PriorityQueue<Integer>[][] map = new PriorityQueue[N + 1][N + 1];

		Grow[][] grow = new Grow[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = new PriorityQueue<Integer>();
				grow[i][j] = new Grow(5, Integer.parseInt(temp.nextToken()));
			}
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(tmp.nextToken()); // 나무의 x 좌표
			int y = Integer.parseInt(tmp.nextToken()); // 나무의 y 좌표
			int age = Integer.parseInt(tmp.nextToken()); // 나무의 초기 나이
			
			map[x][y].add(age);
		}
		for(int l = 0; l < K; l++) {
			// 봄
			ArrayList<Integer> al = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					al.clear();
					int num = 0;
					// 나무가 자란곳이라면?
					if(map[i][j].size() > 0) {
						int size = map[i][j].size();
						for(int k = 0; k < size; k++) {
							 // 가장 어린 나무를 뽑아서
							 int t = map[i][j].poll();
							 
							 // 나무가 뽑아먹을 수 있으면 
							 if(t <= grow[i][j].start_num) {
								 grow[i][j].start_num -= t;
								 t++;
								 al.add(t); // 살아있는 나무 저장
							 }
							 // 뽑아먹을 수 없으면 죽음
							 else {
								 // 나무 나이의 절반만큼 양분이됨
								 num += t / 2;
							 }
						}
						// 살아남은 나무의 양만큼 다시 PQ에 넣어줌
						for(int m = 0; m < al.size(); m++) {
							map[i][j].add(al.get(m));
						}
					}
					// 여름 죽은나무 점수 num을 grow에 추가
					grow[i][j].start_num += num;
				}
			}
			//가을
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					al.clear();
					// 나무가 자라난 곳이면
					if(map[i][j].size() > 0) {
						int size = map[i][j].size();
						for(int age : map[i][j]) {
							
							if(age % 5 == 0) {
								for(int m = 0; m < 8; m++) {
									
									int ni = i + dx[m];
									int nj = j + dy[m];
									
									if(ni >= 1 && nj >= 1 && ni < N + 1 && nj < N + 1) {
										map[ni][nj].add(1);
									}
								}
							}
						}
						for(int m = 0; m < al.size(); m++) {
							map[i][j].add(al.get(m));
						}
					}
				}
			}
			
			//겨울
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					grow[i][j].start_num += grow[i][j].grow_num;
				}
			}

		}
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				sum += map[i][j].size();
			}
		}
		System.out.println(sum);
		
	}
}