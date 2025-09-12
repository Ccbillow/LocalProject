package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num_547_5 {

    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        visited = new boolean[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int idx) {
        visited[idx] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (isConnected[idx][i] == 1) {
                dfs(isConnected, i);
            }
        }
    }

}
