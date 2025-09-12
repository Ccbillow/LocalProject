package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num_547_4 {

    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        visited = new boolean[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, i);
                res++;
            }
        }
        return res;
    }

    private void bfs(int[][] isConnected, int idx) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

            for (int i = 0; i < isConnected.length; i++) {
                if (visited[i]) {
                    continue;
                }

                if (isConnected[cur][i] == 1) {
                    q.addLast(i);
                    visited[i] = true;
                }
            }
        }
    }
}
