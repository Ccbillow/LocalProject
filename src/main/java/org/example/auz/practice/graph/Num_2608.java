package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2608. shortest-cycle-in-a-graph
 * https://leetcode.cn/problems/shortest-cycle-in-a-graph/description/
 */
public class Num_2608 {

    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];
        Arrays.setAll(graph, k -> new LinkedList<>());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            int len = bfs(graph, i);
            if (len != -1) {
                min = Math.min(min, len);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int bfs(List<Integer>[] graph, int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(start);

        //dist[i]: start -> i
        int[] dist = new int[graph.length];
        int[] parent = new int[graph.length];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            for (Integer nei : graph[cur]) {
                // not visited
                if (dist[nei] == -1) {
                    dist[nei] = dist[cur] + 1;
                    parent[nei] = cur;
                    q.addLast(nei);
                } else {
                    // visited
                    if (parent[cur] != nei) {
                        min = Math.min(min, dist[cur] + dist[nei] + 1);
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }


}
