package org.example.auz.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 2101. Detonate the Maximum Bombs
 * https://leetcode.com/problems/detonate-the-maximum-bombs/description/
 */
public class Num_2101_2 {

    public int maximumDetonation(int[][] bombs) {
        List<Integer>[] graph = new LinkedList[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < bombs.length; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long dx = x1 - x2;
                long dy = y1 - y2;
                if (dx * dx + dy * dy <= r1 * r1) {
                    graph[i].add(j);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[graph.length];
            max = Math.max(max, dfs(graph, i, visited));
        }
        return max;
    }

    private int dfs(List<Integer>[] graph, int i, boolean[] visited) {
        visited[i] = true;
        int count = 1;
        for (Integer nei : graph[i]) {
            if (!visited[nei]) {
                count = count + dfs(graph, nei, visited);
            }
        }
        return count;
    }
}
