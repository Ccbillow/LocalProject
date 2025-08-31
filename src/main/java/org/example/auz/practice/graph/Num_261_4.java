package org.example.auz.practice.graph;

public class Num_261_4 {

    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }

        UF uf = new UF(n);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (uf.connected(x, y)) {
                return false;
            }

            uf.union(x, y);
        }
        return uf.count() == 1;
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

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootQ != rootP) {
                parent[rootP] = rootQ;
                count--;
            }
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }


}
