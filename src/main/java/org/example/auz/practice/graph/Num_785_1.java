package org.example.auz.practice.graph;

/**
 * 785. Is Graph Bipartite?
 *
 * https://leetcode.com/problems/is-graph-bipartite/description/
 */
public class Num_785_1 {

    private boolean res = true;

    private boolean[] visited;
    private boolean[] color;

    public boolean isBipartite(int[][] graph) {
        color = new boolean[graph.length];
        visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return res;
    }

    private void traverse(int[][] graph, int i) {
        if (!res) {
            return;
        }

        visited[i] = true;

        for (int n : graph[i]) {
            if (!visited[n]) {
                color[n] = !color[i];
                traverse(graph, n);
            } else {
                if (color[n] == color[i]) {
                    res = false;
                }
            }
        }
    }
}
