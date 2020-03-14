package home;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_SWEA_1210_Ladder1
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = 100;
            int T;
            int col = 0; // 왼쪽에서 오른쪽으로 
            int low = 0; // 위에서 아래로
            T=sc.nextInt(); // 테스트 케이스 수
             
            int[][] map = new int[N][N+2]; // 맵 col 0~101 low 0~99
//          // 맵 초기화
            for (int i = 0; i < N; i++) {
                for(int j  = 1; j < N+1; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int find = 1; find < N+1; find++) {
                if(map[99][find] == 2) {
                    low = 99;
                    col = find;
                    break;
                }
            }
            while(low != 0) {
                 
                if(map[low][col-1] == 0 && map[low][col+1] == 0) {
                    low--;
                }
                else if( map[low][col-1] == 0 && map[low][col+1] == 1) {
                    while(map[low][col+1] != 0) {
                        col++;
                    }
                    low--;
                }
                else if( map[low][col-1] == 1 && map[low][col+1] == 0) {
                    while(map[low][col-1] != 0) {
                        col--;
                    }
                    low--;
                }
            }
            System.out.println("#"+ T + " " + (col-1)); 
        }
    }
}