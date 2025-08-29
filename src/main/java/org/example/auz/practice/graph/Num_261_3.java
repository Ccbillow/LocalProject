package org.example.auz.practice.graph;

import org.example.auz.blind75.tool.graph.UnionFind;

/**
 * LeetCode 261. Graph Valid Tree
 */
public class Num_261_3 {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (uf.connected(a, b)) {
                return false;
            }

            uf.union(a, b);
        }
        return uf.count() == 1;
    }

}
