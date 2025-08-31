package org.example.auz.practice.graph;

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/?show=1
 */
public class Num_547_1 {

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;

        UF uf = new UF(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count();
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
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                count--;
                parent[rootx] = rooty;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
