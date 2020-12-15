package solution;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
 
{
    int top;
    static int[] stack;
    int size;
     
    public Solution(int size) {
        top = -1;
        stack = new int[size];
        this.size = size;
    }
 
    public void push(char value) {
        stack[++top] = value;
    }
 
    public int pop() {
        return stack[top--];
    }
 
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
         
        for(int test_case = 1; test_case <= 10; test_case++)
        {   
            int sol = 0;
            int push_cnt = 0;
            int size = 0;
            size=sc.nextInt(); // test_case문자열의 길이
             
            String str = sc.next();
            Solution st = new Solution(size);
            for(int i = 0; i < size; i++) {
                char a = str.charAt(i);
                if(a == '('  || a == '[' || a == '<' || a == '{') {
                    st.push(a);
                    push_cnt++;
                }
                else if ( a == '}') {
                    if(stack[push_cnt-1] == '{') {
                        st.pop();
                        push_cnt--;
                    }else {
                        sol =0;
                        break;
                    }
                }
                else if ( a == ']') {
                    if(stack[push_cnt-1] == '[') {
                        st.pop();
                        push_cnt--;
                    }else {
                        sol =0;
                        break;
                    }
                }
                else if ( a == '>') {
                    if(stack[push_cnt-1] == '<') {
                        st.pop();
                        push_cnt--;
                    }else {
                        sol =0;
                        break;
                    }
                }
                else if ( a == ')') {
                    if(stack[push_cnt-1] == '(') {
                        st.pop();
                        push_cnt--;
                    }else {
                        sol =0;
                        break;
                    }
                }
 
            }
            if(push_cnt == 0) {
                sol = 1;
            }
            System.out.println("#" + test_case + " " + sol);
        }
    }
}
