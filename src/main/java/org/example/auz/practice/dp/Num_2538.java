package org.example.auz.practice.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 2538. difference-between-maximum-and-minimum-price-sum
 * https://leetcode.cn/problems/difference-between-maximum-and-minimum-price-sum/description/
 */
public class Num_2538 {

    long res = 0L;

    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            int sum = dfs(graph, i, -1, price);
            res = Math.max(res, sum);
        }
        return res;

    }

    private int dfs(List<Integer>[] graph, int idx, int parent, int[] price) {
        int result = 0;

        for (int nei : graph[idx]) {
            if (nei == parent) {
                continue;
            }

            int sub = dfs(graph, nei, idx, price);

            result = Math.max(result, sub);
        }

        int val = price[idx];

        if (parent != -1) {
            result = result + val;
        }
        return result;
    }
}
