package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 310. minimum-height-trees
 * https://leetcode.cn/problems/minimum-height-trees/description/?show=1
 */
public class Num_310_3 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                q.addLast(i);
            }
        }

        int nodeCount = n;
        while (nodeCount > 2) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer cur = q.removeFirst();

                for (Integer nei : graph[cur]) {
                    graph[nei].remove(cur);

                    if (graph[nei].size() == 1) {
                        q.addLast(nei);
                    }
                }
            }
            nodeCount = nodeCount - size;
        }
        return q;
    }
}
