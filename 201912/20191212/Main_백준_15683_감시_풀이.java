package com.ssafy;

import java.util.*;
import java.io.*;

// 1. CCTV 찾기

// 2. 해당 CCTV 별로 회전가능한 경우의 수 시도

// 3. 해당 CCTV의 회전경우의 바라봐야하는 모든 방향 시도

public class Main_백준_15683_감시_풀이 {
	static class CCTV{
		int x,y,no;
		public CCTV(int x, int y, int no) {
			super();
			this.x = x;
			this.y = y;
			this.no = no;
		}
		@Override
		public String toString() {
			return "CCTV [x=" + x + ", y=" + y + ", no=" + no + "]";
		}
	}
	static int N,M, map[][];
	static final int R=0,D=1,L=2,U=3; // �����»�
	static int[][][] direction = {
			null, 
			{{R},{D},{L},{U}}, // CCTV1
			{{L,R},{U,D}},
			{{U,R},{R,D},{D,L},{L,U}},
			{{L,U,R},{U,R,D},{R,D,L},{D,L,U}},
			{{R,D,L,U}}
	};// �� CCTV�� 90�� ȸ�������� ������ �����
	static int[] dx = {0,1,0,-1};// R D L U
	static int[] dy = {1,0,-1,0};
	static ArrayList<CCTV> list = null;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<CCTV>();
		min = Integer.MAX_VALUE;
		for (int i = 0,no=0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				no= map[i][j]= Integer.parseInt(st.nextToken());
				if(no>0 && no<6) list.add(new CCTV(i,j,no));
			}
		}
		watch(0);// ����Ʈ�� ù��° CCTV���� ó��
		System.out.println(min);
	}

	// i��° CCTV�� ��� ������ ȸ���� ����� �� �õ�
	private static void watch(int i) {
		
		if(i==list.size()) {
			int count = 0;
			for (int a=0; a<N; a++) {
				for(int b=0; b<M; ++b) {
					if(map[a][b]==0) ++count;
				}
			}
			if(min>count) min = count;
			return;
		}
		
		CCTV tv = list.get(i);
		int nx,ny,r;
		int[][] dir = direction[tv.no];
		
		int[][] temp = new int[N][];
		for (int t = 0; t < N; t++) temp[t] = Arrays.copyOf(map[t], M);
		
		// �ش� CCTV�� ȸ������Ǽ���ŭ �ݺ�
		for (int c = 0; c < dir.length; c++) {
			// �� ȸ���� �ٶ󺸴� ���⸸ŭ �ݺ�
			for(int d = 0; d<dir[c].length; ++d) {
				nx = tv.x;
				ny = tv.y;
				r = dir[c][d]; // R,L,U,D
				while(true) {
					nx += dx[r];
					ny += dy[r];
					if(nx<0 || nx>= N || ny<0 || ny>=M || map[nx][ny]==6) break;
					if(map[nx][ny]>0 && map[nx][ny]<6) continue;
					map[nx][ny] = 9;
				}
			}
			watch(i+1);
			
			// �������� ó���� ���û�Ȳ�� ��ȿ��(����������ó��) �ǵ�������
			for (int a = 0; a < N; a++) {
				for(int b=0; b<M; ++b) map[a][b] = temp[a][b];
			}
			
		}
	}
}
