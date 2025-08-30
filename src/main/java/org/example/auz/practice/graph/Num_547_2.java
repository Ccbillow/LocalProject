package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/?show=1
 */
public class Num_547_2 {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }


    void bfs(int[][] isConnected, int i, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[i] = true;
        q.addLast(i);

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

            for (int j = 0; j < isConnected.length; j++) {
                if (visited[j]) {
                    continue;
                }

                if (isConnected[cur][j] == 1) {
                    q.addLast(j);
                    visited[j] = true;
                }
            }
        }
    }

    void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (visited[j]) {
                continue;
            }

            if (isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }

}
