package org.example.auz.practice.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1584. min-cost-to-connect-all-points
 * https://leetcode.cn/problems/min-cost-to-connect-all-points/description/
 *
 * kruskal
 *
 * time: O(m * log m) = O(m * log m) + m * O(1)
 * space: O(m + n)
 */
public class Num_1584_1 {

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int xi = points[i][0];
                int xj = points[j][0];
                int yi = points[i][1];
                int yj = points[j][1];

                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);

                edges.add(new int[]{i, j, dist});
            }
        }

        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        int res = 0;
        UF uf = new UF(points.length);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int weight = edge[2];

            if (!uf.connected(x, y)) {
                uf.union(x, y);
                res = res + weight;
            }

            if (uf.count == 1) {
                return res;
            }
        }
        return res;
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
