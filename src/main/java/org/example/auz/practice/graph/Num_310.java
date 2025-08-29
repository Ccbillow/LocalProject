package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/description/?show=1
 */
public class Num_310 {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                q.addLast(i);
            }
        }

        int nodeCount = n;
        while (nodeCount > 2) {
            int size = q.size();
            nodeCount = nodeCount - size;
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();

                for (int neighbor : graph.get(cur)) {
                    graph.get(neighbor).remove(Integer.valueOf(cur));
                    if (graph.get(neighbor).size() == 1) {
                        q.addLast(neighbor);
                    }
                }
            }
        }

        return q;
    }
}
