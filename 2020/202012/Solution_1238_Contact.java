package solution;

import java.io.FileInputStream;
import java.util.*;
 
public class Solution_1238_Contact {
    static boolean[] visit;
    static ArrayList<Integer>[]  mapArrayList;
    static int[] dept;
     
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        for(int tc = 1; tc <= 10; tc++) {
            int max_dept = 0;
            int max_len = 0;
             
            mapArrayList = new ArrayList[101];
            Queue<Integer> queue = new LinkedList<Integer>();
            int data_len = sc.nextInt(); // 데이터의 길이
            int start = sc.nextInt(); // 시작점
            visit = new boolean[101];
            dept = new int[101];
            visit[start] = true;
            dept[start] = 1;
            queue.add(start);
            //쌍으로 들어오니까 데이터 길이의 절반만큼 돌면서
            for(int i = 1; i <= 100; i++) {
                mapArrayList[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i < data_len / 2; i++) {
                int st = sc.nextInt(); // 출발지점
                int end = sc.nextInt(); // 도착지점
                 
                mapArrayList[st].add(end);
            }
            while(!queue.isEmpty()) {
                int temp = queue.poll(); // q가 비어있지 않으면 앞에서 하나 뽑음
                 
                // 위에서 뽑은 좌표의 리스트에 들어있는 사이즈 만큼 돌면서 내부에 있는 값을 q에넣고 방문
                for(int i = 0; i < mapArrayList[temp].size(); i++) {
                    if(!visit[(mapArrayList[temp].get(i))]) {
                        dept[mapArrayList[temp].get(i)] = dept[temp] + 1; // 지금 뽑혀있는 깊이의 + 1 한 값
                        queue.add(mapArrayList[temp].get(i));  // 큐에 리스트 넣어줌
                        visit[mapArrayList[temp].get(i)] = true;  // 방문 했다고 찍음
                        max_len = dept[temp] + 1; // 최대 깊이 갱신
                    }
                }
            }
            for(int i = 0; i < 100; i++) {
                if(dept[i] == max_len) {
                    max_dept = i;
                }
            }
            System.out.println("#" + tc + " " +max_dept);   
        }
    }
}