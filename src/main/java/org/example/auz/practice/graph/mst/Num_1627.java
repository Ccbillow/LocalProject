package org.example.auz.practice.graph.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 1627. graph-connectivity-with-threshold
 *
 * https://leetcode.cn/problems/graph-connectivity-with-threshold/description/
 */
public class Num_1627 {

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UF uf = new UF(n + 1);
        for (int i = threshold + 1; i * 2 <= n; i++) {
            for (int j = i * 2; j <= n; j = j + i) {
                uf.union(i, j);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            res.add(uf.connected(a, b));
        }
        return res;
    }

    class UF {
        int count;
        int[] parent;
        int[] rank;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rootx] = rooty;
                    rank[rootx]++;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
