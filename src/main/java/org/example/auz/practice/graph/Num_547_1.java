package org.example.auz.practice.graph;

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/?show=1
 */
public class Num_547_1 {

    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            int root = find(parent[x]);

            parent[x] = root;
            return root;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            parent[rootP] = rootQ;
            count--;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
