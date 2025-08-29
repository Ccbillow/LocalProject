package org.example.auz.practice.graph;

import java.util.LinkedList;

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/description/
 */
public class Num_886_1 {

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
                traverse(graph, i);
            }
        }
        return res;
    }

    private void traverse(LinkedList<Integer>[] graph, int i) {
        if (!res) {
            return;
        }

        visited[i] = true;

        for (Integer n : graph[i]) {
            if (!visited[n]) {
                color[n] = !color[i];
                visited[n] = true;
                traverse(graph, n);
            } else {
                if (color[n] == color[i]) {
                    res = false;
                }
            }
        }
    }
}
