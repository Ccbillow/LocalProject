package org.example.auz.practice.graph.mst;

import java.util.Arrays;

/**
 * LeetCode 1135. Connecting Cities With Minimum Cost
 *
 * kruskal
 */
public class Num_1135_1 {

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UF uf = new UF(n);

        int total = 0;
        for (int[] edge : connections) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int cost = edge[2];

            // every time, add min edge to mst, if no cycle
            if (!uf.connected(from, to)) {
                uf.union(from, to);
                total = total + cost;
            }
        }

        return uf.count == 1 ? total : -1;
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
                parent[rootx] = rooty;
                count--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
