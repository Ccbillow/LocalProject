package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 2039. the-time-when-the-network-becomes-idle
 * https://leetcode.cn/problems/the-time-when-the-network-becomes-idle/description/
 */
public class Num_2039 {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        dist[0] = 0;
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int nei : graph[cur]) {
                if (!visited[nei]) {
                    q.addLast(nei);
                    path[nei] = cur;
                    dist[nei] = dist[cur] + 1;
                    visited[nei] = true;
                }
            }
        }

        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            int total = 2 * dist[i];
            int lastSend = ((total - 1) / patience[i]) * patience[i];
            int last = total + lastSend;
            res = Math.max(last, res);
        }
        return res + 1;
    }
}
