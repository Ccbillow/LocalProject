package org.example.auz.blind75.tool.graph;

public class UnionFind {

    private int count;
    private int[] parent;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootQ == rootP) {
            return;
        }

        parent[rootQ] = rootP;
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        int root = find(parent[x]);

        parent[x] = root;
        return root;
    }

    public int count() {
        return count;
    }
}
