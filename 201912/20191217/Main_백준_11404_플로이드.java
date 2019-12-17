	package com.ssafy;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class Main_백준_11404_플로이드 {
		static int INF = 987654321;
		static int N;
		static int[][] distance;
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			N = Integer.parseInt(br.readLine()); // 도시 (간선 수)
			
			int B = Integer.parseInt(br.readLine()); // 버스 수 
			
			distance = new int[N + 1][N + 1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) {
						continue;
					}
					distance[i][j] = INF;
				}
			}
			StringTokenizer str = null;
			for(int i = 0; i < B; i++) {
				str = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(str.nextToken());
				int end = Integer.parseInt(str.nextToken());
				int time = Integer.parseInt(str.nextToken());
				
				distance[start][end] = Math.min(distance[start][end], time);
			}
			floydWarshall();
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(distance[i][j] >= INF) {
						System.out.print("0 ");
					}
					else {
						System.out.print(distance[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
	    public static void floydWarshall() {
	        // 기준이 되는 거쳐가는 노드 K
	        for(int k = 1; k <= N; k++) {
	            // 출발하는 노드 i
	            for(int i=1; i <= N; i++) {
	                // 도착하는 노드 j
	                for(int j=1; j <= N; j++) {
	                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
	                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
	                }
	            }
	        }
	    }
	}
