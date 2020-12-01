package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_백준_2493_탑 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] tower = new int[Integer.parseInt(input)];
		int[] receive_tower = new int[Integer.parseInt(input)];

		String line = br.readLine();
		String[] sa = line.split(" ");
		for(int i = 0; i < tower.length; i++) {
			tower[i] = Integer.parseInt(sa[i]);
		}
		
		for(int i = tower.length - 1; i > 0; i--) {
			for(int j = i - 1 ; j >= 0; j--) {
				if(tower[i] <= tower[j]) {
					receive_tower[i] = j + 1;
					break;
				}
			}
		}
		for(int i =0; i < tower.length; i++) {
			System.out.print(receive_tower[i] + " ");
		}
		
		
	}
}
