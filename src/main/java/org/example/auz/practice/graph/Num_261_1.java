package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 261. Graph Valid Tree
 */
public class Num_261_1 {
    boolean[] visited;
    boolean hasCycle = false;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];

        traverse(graph, 0, -1);

        if (hasCycle) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    void traverse(List<List<Integer>> graph, int i, int parent) {
        if (hasCycle) {
            return;
        }

        visited[i] = true;

        for (Integer neighbor : graph.get(i)) {
            if (neighbor == parent) {
                continue;
            }

            if (visited[neighbor]) {
                hasCycle = true;
                return;
            }

            traverse(graph, neighbor, i);
        }
    }
}
