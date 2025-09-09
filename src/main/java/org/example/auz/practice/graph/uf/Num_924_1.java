package org.example.auz.practice.graph.uf;

/**
 * 924. minimize-malware-spread
 * https://leetcode.cn/problems/minimize-malware-spread/description/?show=1
 */
public class Num_924_1 {


    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        int[] cnt = new int[n];
        for (int i : initial) {
            cnt[uf.find(i)]++;
        }

        int res = -1;
        int max = -1;
        int minId = n;
        for (int i : initial) {
            minId = Math.min(minId, i);
            int root = uf.find(i);
            if (cnt[root] == 1) {
                int size = uf.size(root);
                if (size > max) {
                    res = i;
                    max = size;
                } else if (size == max && i < res) {
                    res = i;
                }
            }
        }
        return res == -1 ? minId : res;
    }

    class UF {
        int count;
        int[] parent;
        int[] size;

        public UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int count() {
            return count;
        }

        int size(int x) {
            return size[x];
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
                if (size[rootx] > size[rooty]) {
                    parent[rooty] = rootx;
                    size[rootx] = size[rootx] + size[rooty];
                } else {
                    parent[rootx] = rooty;
                    size[rooty] = size[rootx] + size[rooty];
                }
            }
            count--;
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

}
