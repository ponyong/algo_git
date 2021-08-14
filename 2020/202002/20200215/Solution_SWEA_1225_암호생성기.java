package home;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution_SWEA_1225_암호생성기
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T;
            T=sc.nextInt(); // TestCase 번호 처리용 
             
            int[] arr = new int[8];
            int temp = 0; // 변수 저장용
            for ( int i = 0; i < 8; i++) {
                arr[i] = sc.nextInt();
            }
            do {
                for ( int minus = 1; minus <= 5; minus++) {
                    temp = arr[0];
 
                    for(int j = 0; j < 7; j++) {
                        arr[j] = arr[j+1];
                    }
                    if(temp - minus <= 0) {
                        arr[7] = 0;
                        break;
                    }
                    arr[7] = temp - minus;
                }
            }while(arr[7] > 0);
            System.out.print("#" + T + " ");
            for(int i = 0; i < 8; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } 
         
    }
}