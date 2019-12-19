package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2884_알람시계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		int time = H * 60 + M; // 총합 분
		
		if(time - 45 < 0) {
			time = time - 45;
			time += 1440;
		}
		else {
			time = time - 45;
		}
		
		System.out.println((time / 60) + " " + time % 60);
	}
}
