package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사람 수
		
		int[][] score = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				score[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		int min = Integer.MAX_VALUE / 2;
		List<Integer> team1 = new ArrayList<>();
		List<Integer> team2 = new ArrayList<>();
		for(int i = 1; i < ( 1 << N - 1); i++) {
			team1.clear();
			team2.clear();
			for(int j = 0; j < N; j++) {
				if((i & 1 << j) > 0) {
					team1.add(j);
				}
				else {
					team2.add(j);
				}
			}
			int team1_sum = 0;
			int team2_sum = 0;
			if(team1.size() != N/2 || team2.size() != N/2 ) {
				continue;
			}
			else {
				for(int k = 0; k < team1.size(); k++) {
					for(int l = k; l < team1.size(); l++) {
						team1_sum += score[team1.get(k)][team1.get(l)];
						team1_sum += score[team1.get(l)][team1.get(k)];
					}
				}
				for(int k = 0; k < team2.size(); k++) {
					for(int l = k; l < team2.size(); l++) {
						team2_sum += score[team2.get(k)][team2.get(l)];
						team2_sum += score[team2.get(l)][team2.get(k)];
					}
				}
				
				int result = Math.abs(team1_sum - team2_sum);
				min = Math.min(min, result);
			}
		} 
		System.out.println(min);
	}
}
