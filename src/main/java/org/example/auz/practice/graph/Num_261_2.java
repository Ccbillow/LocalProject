package org.example.auz.practice.graph;

/**
 * LeetCode 261. Graph Valid Tree
 */
public class Num_261_2 {

    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a = find(parent, edge[0]);
            int b = find(parent, edge[1]);
            if (a == b) {
                return false;
            }
            parent[a] = b;
        }
        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        int root = find(parent, parent[x]);

        parent[x] = root;
        return root;
    }

}
