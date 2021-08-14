package home;

import java.io.FileInputStream;
import java.util.Scanner;
  
public class Solution_SWEA_1227_미로2 {
    static int[][] map = new int[100][100];
    static boolean flag = false;
      
    // 시작 좌표를 받아서
    public static void isVisit(int x, int y) {
        if(flag == true) {
            return;
        }
        if(map[x][y] == 3) {
            flag =true;
            return;
        }
        // 방문한 곳은 1로 변경
        map[x][y] = 1;
        if(map[x+1][y] != 1) {
            isVisit(x+1, y);
        }
        if(map[x-1][y] != 1) {
            isVisit(x-1,y);
        }
        if(map[x][y-1] != 1) {
            isVisit(x,y-1);
        }
        if(map[x][y+1] != 1) {
            isVisit(x,y+1);
        }
  
    }
      
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1 ; test_case <= 10; test_case++) {
            int T = sc.nextInt(); // TestCase
            int low = 0; // 위에서 아래로
            int col = 0; // 
            sc.nextLine();
              
            for(int i = 0; i < 100; i++) {
                String nl = sc.nextLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = nl.charAt(j) - '0';
                }
            }
            for(int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if(map[i][j] == 2) {
                        col = j;
                        low = i;
                        break;
                    }
                }
            }
            isVisit(low, col);
            int sol = 0;
            if(flag == true) {
                sol = 1;
            }
            System.out.println("#"+ T + " " + sol);
            flag = false;
        }
      
    }
}