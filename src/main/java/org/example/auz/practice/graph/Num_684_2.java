package org.example.auz.practice.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 684. redundant-connection
 * https://leetcode.cn/problems/redundant-connection/description/
 */
public class Num_684_2 {

    boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        visited = new boolean[n + 1];

        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            Arrays.fill(visited, false);
            if (dfs(graph, u, v)) {
                return edge;
            }

            graph[u].add(v);
            graph[v].add(u);
        }

        return new int[0];
    }

    private boolean dfs(List<Integer>[] graph, int i, int j) {
        if (i == j) {
            return true;
        }

        visited[i] = true;
        for (Integer nei : graph[i]) {
            if (!visited[nei]) {
                if (dfs(graph, nei, j)) {
                    return true;
                }
            }
        }
        return false;
    }


}
