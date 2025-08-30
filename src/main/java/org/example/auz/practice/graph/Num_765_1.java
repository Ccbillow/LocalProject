package org.example.auz.practice.graph;

/**
 * 765. Couples Holding Hands
 * https://leetcode.com/problems/couples-holding-hands/description/?show=1
 */
public class Num_765_1 {


    public int minSwapsCouples(int[] row) {
        UF uf = new UF(row.length);
        for (int i = 0; i < row.length; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return row.length - uf.count;
    }

    class UF {
        int[] parent;
        int count;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            int root = find(parent[x]);
            parent[x] = root;
            return root;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootQ == rootP) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        int count() {
            return count;
        }
    }
}
