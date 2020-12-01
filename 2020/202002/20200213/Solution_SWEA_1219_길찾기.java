package home;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_SWEA_1219_길찾기 {
    static boolean[] visit = new boolean[100];
    static ArrayList[]  mapArrayList = new ArrayList[100];
    static boolean flag = false;
    public static void dfs(int i) {
        if( i == 99) {
            flag = true;
        }
        if(flag == true) {
            return;
        }
        visit[i] = true;
        for(int j = 0 ; j < mapArrayList[i].size(); j++) {
            int temp = (int) mapArrayList[i].get(j);
            if(!visit[temp]) {
                dfs(temp);
            }
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        for(int test_case = 1; test_case <= 10; ++test_case) {
            int T = sc.nextInt(); // TestCase 번호
            int road_num = sc.nextInt(); // 길의 총 갯수
             
//          int[][] map = new int[100][100]; 인접행렬
             
            // 인접리스트로 만들었을때
            for(int i = 0; i < 100; i++) {
                mapArrayList[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i < road_num; i++) {
                int start = sc.nextInt(); // 시작지점
                int end = sc.nextInt(); // 도착지점
                 
                mapArrayList[start].add(end);
            }
             
            dfs(0);
            System.out.print("#" + test_case + " ");
            if(flag == true) {
                System.out.println("1");
            }
            else { 
                System.out.println("0");
            }
            flag = false;
            Arrays.fill(visit, false); // 배열 초기화 함수
        }
    }
}