package org.example.auz.practice.graph;

import java.util.LinkedList;

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/description/
 */
public class Num_886_2 {

    boolean res = true;
    boolean[] visited;
    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];

        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(graph, i);
            }
        }
        return res;
    }

    private void bfs(LinkedList<Integer>[] graph, int i) {
        LinkedList<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.addLast(i);

        while (!q.isEmpty() && res) {
            Integer cur = q.removeFirst();

            for (Integer n : graph[cur]) {
                if (visited[n]) {
                    if (color[n] == color[cur]) {
                        res = false;
                        return;
                    }
                } else {
                    color[n] = !color[cur];
                    visited[n] = true;
                    q.addLast(n);
                }
            }
        }
    }
}
