package org.example.auz.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 323. Number of Connected Components in an Undirected Graph
 *
 * time: O(n + edges)
 * space: O(n)
 */
public class Num_323_2 {

    public int countComponents(int n, int[][] edges) {

        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    void dfs(LinkedList<Integer>[] graph, int i, boolean[] visited) {
        visited[i] = true;

        for (int nei : graph[i]) {
            if (visited[nei]) {
                continue;
            }

            visited[nei] = true;
            dfs(graph, nei, visited);
        }
    }

}
