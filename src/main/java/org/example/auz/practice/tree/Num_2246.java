package org.example.auz.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 2246. longest-path-with-different-adjacent-characters
 * https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/description/
 */
public class Num_2246 {

    int n;
    int res = Integer.MIN_VALUE;

    public int longestPath(int[] parent, String s) {
        n = parent.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int par = parent[i];
            graph[par].add(i);
        }

        dfs(graph, s, 0);

        return res;
    }

    int dfs(List<Integer>[] graph, String s, int idx) {
        if (idx > n) {
            return 0;
        }

        int first = 0;
        int second = 0;
        for (Integer nei : graph[idx]) {
            int depth = dfs(graph, s, nei);

            if (depth > first && s.charAt(idx) != s.charAt(nei)) {
                second = first;
                first = depth;
            } else if (depth > second && s.charAt(idx) != s.charAt(nei)) {
                second = depth;
            }
        }

        res = Math.max(res, first + second + 1);

        return first + 1;
    }
}
