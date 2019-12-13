package com.ssafy;
import java.util.*;
 
public class Main_백준_1707_이분그래프_서울8반_권혁진 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while ( t-- > 0 ) {
            int n = sc.nextInt();
            int e = sc.nextInt();
            //ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
            ArrayList<Integer>[] d = ( ArrayList<Integer>[] ) new ArrayList[n+1];
            int[] check = new int[n+1];
            boolean rt = false;
            for (int i=1; i<=n; i++) {
               d[i] = new ArrayList<Integer>();
            }
              
            for ( int i =0 ; i < e ; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
            
                d[u].add(v); d[v].add(u); 
            }
            
            for ( int i= 1 ; i <= n ; i++ ) {
                //아직 check 안한 부분 검사
                if ( check[i] == 0  ) {
                    rt = dfs(d , check , i, 1);
                }
            }
            
            for ( int i=1 ; i<=n; i++) {
                for ( int x : d[i]) {
                    if ( check[i] == check[x] ) {
                        rt= false;
                    }
                }
            }     
            System.out.println( rt==true?"YES":"NO" );
        }
    }
    public static boolean dfs(ArrayList<Integer>[] d, int[] c , int x, int cnt) {
        c[x] = cnt;
        
        for ( int i : d[x] ) {
            if ( c[i] == 0 ) {
                if ( dfs( d , c , i , 3-cnt ) == false ) {
                    return false;
                }
            }
 
        }
        return true;
    }
}