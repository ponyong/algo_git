package home;

import java.io.FileInputStream;
import java.util.*;
 
public class Solution_SWEA_1486_장훈이의높은선반 {
    static int N;
    static int B;
    static List<Integer> list;
    static int min = Integer.MAX_VALUE;
    public static void solve(int people , int num ) {
        // N명 다 순회 했으면 
        if(people == N-1) {
            if(num - B >= 0) {
                min = Math.min(min, num - B);
            }
            return;
        }
        solve(people + 1 , num);
        solve(people + 1 , num + list.get(people + 1));
    }
    public static void main(String[] args) throws Exception {
//      System.setIn(new FileInputStream("res/input_1486.txt"));
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt(); // test_case
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 점원의 수
            B = sc.nextInt(); // 탑의 높이
            list = new ArrayList<Integer>();
            for(int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }
 
            solve(0, 0); // 첫번째 직원이 선택된 경우
            solve(0, list.get(0)); // 첫번째 직원이 선택 안된 경우
             
            System.out.println("#" + tc + " " + min);
            min = Integer.MAX_VALUE;
        }
         
    }
}