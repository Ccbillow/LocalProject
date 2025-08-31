package org.example.auz.practice.graph;

/**
 * LeetCode 323. Number of Connected Components in an Undirected Graph
 *
 * time: O(n + edges)
 * space: O(n)
 */
public class Num_323_1 {

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!uf.connected(x, y)) {
                uf.union(x, y);
            }
        }
        return uf.count();
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int count() {
            return count;
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootY != rootX) {
                parent[rootX] = rootY;
                count--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
