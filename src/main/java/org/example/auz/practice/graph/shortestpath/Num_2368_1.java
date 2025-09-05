package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2368. reachable-nodes-with-restrictions
 *
 * https://leetcode.cn/problems/reachable-nodes-with-restrictions/description/
 */
public class Num_2368_1 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }

        if (set.contains(0)) {
            return 0;
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int count = 0;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();
            count++;

            for (Integer nei : graph[cur]) {
                if (!visited[nei] && !set.contains(nei)) {
                    visited[nei] = true;
                    q.addLast(nei);
                }
            }
        }
        return count;
    }
}
