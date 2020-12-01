package home;

import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;
 
class Solution_SWEA_5432_쇠막대기자르기
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            Stack<Character> s = new Stack<Character>();
            int total = 0;
            char pre = 0;
            int stack_cnt = 0;
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if( temp == '(') {
                    s.push(temp);
                    pre = temp;
                    stack_cnt++;
                }
                else if(temp == ')') {
                    if(pre == '(') {
                        s.pop();
                        stack_cnt--;
                        pre = temp;
                        total += stack_cnt;
                    }
                    else {
                        total++;
                        pre = temp;
                        s.pop();
                        stack_cnt--;
                    }
                }
            }
            System.out.println("#" + test_case + " " + total);
        }   
    }
}