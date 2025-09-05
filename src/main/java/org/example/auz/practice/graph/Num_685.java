package org.example.auz.practice.graph;

/**
 * 685. redundant-connection-ii
 * https://leetcode.cn/problems/redundant-connection-ii/description/
 */
public class Num_685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        int[] a = null;
        int[] b = null;
        for (int[] edge : edges) {
            int par = edge[0];
            int chi = edge[1];
            if (parent[chi] == 0) {
                parent[chi] = par;
            } else {
                a = new int[]{parent[chi], chi};
                b = new int[]{par, chi};
            }
        }

        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (edge == b) {
                continue;
            }

            int x = edge[0];
            int y = edge[1];
            if (uf.connected(x, y)) {
                if (a != null) {
                    return a;
                } else {
                    return edge;
                }
            } else {
                uf.union(x, y);
            }
        }
        return b;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rooty != rootx) {
                parent[rootx] = rooty;
                count--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
