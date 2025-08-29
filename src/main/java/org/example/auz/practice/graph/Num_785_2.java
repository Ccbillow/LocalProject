package org.example.auz.practice.graph;

import java.util.LinkedList;

/**
 * 785. Is Graph Bipartite?
 *
 * https://leetcode.com/problems/is-graph-bipartite/description/
 */
public class Num_785_2 {

    private boolean res = true;

    private boolean[] visited;
    private boolean[] color;

    public boolean isBipartite(int[][] graph) {
        color = new boolean[graph.length];
        visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfs(graph, i);
            }
        }
        return res;
    }

    private void bfs(int[][] graph, int start) {
        LinkedList<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.addLast(start);

        while (!q.isEmpty() && res) {
            Integer cur = q.removeFirst();

            for (int neighbor : graph[cur]) {
                if (!visited[neighbor]) {
                    color[neighbor] = !color[cur];
                    visited[neighbor] = true;
                    q.addLast(neighbor);
                } else {
                    if (color[neighbor] == color[cur]) {
                        res = false;
                        return;
                    }
                }
            }
        }
    }


}
