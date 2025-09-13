package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2101. detonate-the-maximum-bombs
 * https://leetcode.cn/problems/detonate-the-maximum-bombs/description/
 */
public class Num_2101_4 {

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long x = x2 - x1;
                long y = y2 - y1;
                if (x * x + y * y <= r1 * r1) {
                    graph[i].add(j);
                }
            }
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(graph, i));
        }

        return res;
    }

    private int dfs(List<Integer>[] graph, int i) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(i);
        boolean[] visited = new boolean[graph.length];
        visited[i] = true;

        int count = 0;

        while (!stack.isEmpty()) {
            Integer cur = stack.removeLast();
            count++;

            for (Integer nei : graph[cur]) {
                if (visited[nei]) {
                    continue;
                }

                stack.addLast(nei);
                visited[nei] = true;
            }
        }
        return count;
    }
}
