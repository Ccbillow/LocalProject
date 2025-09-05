package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/description/?show=1
 */
public class Num_310_2 {

    List<Integer> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int height = dfs(graph, i, visited);
            if (height < min) {
                min = height;
                res.clear();
                res.add(i);
            } else if (height == min) {
                res.add(i);
            }
        }
        return res;
    }

    private int dfs(List<Integer>[] graph, int i, boolean[] visited) {
        visited[i] = true;
        int height = 0;

        for (Integer nei : graph[i]) {
            if (!visited[nei]) {
                height = Math.max(height, dfs(graph, nei, visited));
            }
        }
        return height + 1;
    }
}
