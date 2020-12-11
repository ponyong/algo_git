package home;

import java.util.*;
class KaKao05 {
    static final int MAXIMUM = 200001;
    static List<Integer>[] adj = new ArrayList[MAXIMUM];
    static List<Integer>[] graph = new ArrayList[MAXIMUM];
    static boolean[] check = new boolean[MAXIMUM];
    static boolean[] visit = new boolean[MAXIMUM];
    static boolean[] finish = new boolean[MAXIMUM];
    static boolean flag;

    private void dfs(int i) {
        visit[i] = true;
        for (int j:adj[i]) {
            if (visit[j])continue;
            graph[i].add(j);
            dfs(j);
        }
    }

    private void isCycle(int i) {
        check[i] = true;
        for (int j:graph[i]) {
            if (!check[j]) {
                isCycle(j);
            } else {
                if (!finish[j]) flag = true;
            }
        }
        finish[i] = true;
    }

    public boolean solution(int n, int[][] path, int[][] order) {
        int u,v;
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            graph[i] = new ArrayList<>();
        } 
        for (int i = 0; i < path.length; i++) {
            u = path[i][0];
            v = path[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(0);
        for (int i = 0; i < order.length; i++) {
            u = order[i][0];
            v = order[i][1];
            graph[u].add(v);
        }
        flag = false;
        isCycle(0);
        for (int i = 0; i < n; i++) {
            visit[i] = check[i] = finish[i] = false;
        }
        for (int i = 0; i < n; i++) {
            adj[i].clear();
            graph[i].clear();
        } 
        return !flag;
    }
}