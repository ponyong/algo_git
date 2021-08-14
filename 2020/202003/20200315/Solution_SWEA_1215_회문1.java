package home;

import java.util.Scanner;
import java.io.FileInputStream;
 
public class Solution_SWEA_1215_회문1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        for(int tc = 0; tc < 10; tc++) {
            int  pal_len = sc.nextInt(); // 찾아야 하는 회문 길이
             
            char[][] map = new char[8][8]; // 8 x 8 map
             
             
            for(int i = 0; i < 8; i++) {
                String str = sc.next();
                for(int j = 0; j < 8; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
             
            int count = 0;
            for(int  a= 0; a < 8; a++) {
                x : for(int b = 0; b < 8; b++) {
                    for (int k = 0; k < pal_len / 2; k++) {
                        if( b > map[a].length - pal_len || map[a][b + k] != map[a][b+ pal_len - 1 - k]) {
                            continue x;
                        }
                        else if ( k * 2 + 2 == pal_len -1 || k * 2 + 1 == pal_len -1) {
                            count++;
                        }
                    }
                }
            }
            for(int  a= 0; a < 8; a++) {
                x : for(int b = 0; b < 8; b++) {
                    for (int k = 0; k < pal_len / 2; k++) {
                        if( a > map.length - pal_len || map[a + k][b] != map[a + pal_len -1 - k][b]) {
                            continue x;
                        }
                        else if ( k * 2 + 2 == pal_len -1 || k * 2 + 1 == pal_len -1) {
                            count++;
                        }
                    }
                }
            }
            System.out.println("#" + (tc+1) + " " + count);
            }
        }
}