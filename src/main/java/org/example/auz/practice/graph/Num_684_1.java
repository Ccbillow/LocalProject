package org.example.auz.practice.graph;

/**
 * 684. redundant-connection
 * https://leetcode.cn/problems/redundant-connection/description/
 */
public class Num_684_1 {

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
            uf.union(edge[0], edge[1]);
        }
        return new int[]{};
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
