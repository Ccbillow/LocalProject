package org.example.auz.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1245. Tree Diameter
 *
 */
public class Num_1245 {

    int res = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(graph, 0, -1);
        return res;
    }

    private int dfs(List<Integer>[] graph, int idx, int parent) {
        int first = 0;
        int second = 0;

        for (Integer nei : graph[idx]) {
            if (nei == parent) {
                continue;
            }

            int depth = dfs(graph, nei, idx);

            if (depth > first) {
                second = first;
                first = depth;
            } else if (depth > second) {
                second = depth;
            }
        }

        res = Math.max(res, first + second);
        return first + 1;
    }
}
