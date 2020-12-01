package home;

import java.io.FileInputStream;
import java.util.*;
 
public class Solution_SWEA_1240_단순2진암호코드 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>();
        // 암호테이블
        int[] arr = new int[8];
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
         
        // 0001011 // 11// 0001101 // 0111011 // 0011001 // 0111011 // 0111011 // 0111011 // 0011001 // 000000 // 000
        int T = sc.nextInt(); // 2
         
        for(int tc = 1; tc <= 10; tc++) {
             
            int row = sc.nextInt(); // 16
            int len = sc.nextInt(); // 80
            String temp = "";
             
            sc.nextLine();
            for(int i = 0; i < row; i++) {
                temp += sc.nextLine();
            }
            int cnt = 7;
            for(int i = 0; i < row * len - 7; i++) {
                if(cnt == 0) {
                    break;
                }
                if(temp.substring(i, i + 7).equals("1000000")) {
                    for(int j = cnt; j >= 0; j--) {
                        arr[j] = map.get(temp.substring(i-6, i+1));
                        i = i - 7;
                        cnt--;
                    }
                    break;
                }
            }
            boolean flag = false;
            int cal = (arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] + arr[7];
            int sol = 0;
            if(cal % 10 == 0) {
                flag = true;
            }
            System.out.print("#" + tc + " ");
            if(flag == true) {
                for(int i = 0; i < arr.length; i++) {
                    sol += arr[i];
                }
                System.out.print(sol);
            }
            else {
                System.out.print("0");
            }
            System.out.println();
        }           
    }
}