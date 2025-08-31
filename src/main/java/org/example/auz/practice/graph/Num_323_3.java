package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 323. Number of Connected Components in an Undirected Graph
 *
 * time: O(n + edges)
 * space: O(n)
 */
public class Num_323_3 {

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
                bfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    void bfs(LinkedList<Integer>[] graph, int i, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

            for (Integer nei : graph[cur]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.addLast(nei);
                }
            }
        }
    }

}
