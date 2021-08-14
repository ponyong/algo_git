package home;

import java.util.*;
import java.io.*;
class Solution
{
    public static int[] queue = new int[100];
    public static int front = -1;
    public static int rear = -1;
     
    public static boolean isEmpty() {
        if(front == rear) return true;
        else return false;
    }
     
    public static boolean isFull() {
        if(rear == queue.length-1) return true;
        else return false;
    }
     
    public static void enQueue(int item) {
        if(isFull()) {
            System.out.println("Queue Full");
            return;
        }
        queue[++rear] = item;
    }
     
    public static int deQueue() { 
        if(isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        return queue[++front];
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            rear = -1;
            front = -1;
            String s = br.readLine();
            String[] sa = s.split(" ");
             
            int len = Integer.parseInt(sa[0]);
            String b = sa[1];
            for(int i = 0; i < len; i++) {
                if(rear != -1 && Character.getNumericValue(b.charAt(i)) == queue[rear]) {
                    rear--;
                }
                else {
                    enQueue(Character.getNumericValue(b.charAt(i)));
                }
            }
            System.out.print("#" + test_case + " ");
            for(int i = 0; i <= rear; i++) {
                System.out.print(deQueue());
            }
            System.out.println();
        }   
    }
}