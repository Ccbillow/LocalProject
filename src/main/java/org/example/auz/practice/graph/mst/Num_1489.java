package org.example.auz.practice.graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1489. find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
 * https://leetcode.cn/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
 */
public class Num_1489 {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] newEdges = new int[edges.length][4];

        for (int i = 0; i < edges.length; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);


        // calculate mst
        int totalWeight = 0;
        UF uf = new UF(n);
        for (int i = 0; i < newEdges.length; i++) {
            int from = newEdges[i][0];
            int to = newEdges[i][1];
            int weight = newEdges[i][2];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
                totalWeight = totalWeight + weight;
            }
        }

        // check critical
        List<Integer> skipRes = getCritical(n, newEdges, totalWeight);

        // check pseudo
        List<Integer> pickRes = getPseudo(n, newEdges, totalWeight);

        return List.of(skipRes, pickRes);
    }

    private List<Integer> getCritical(int n, int[][] newEdges, int totalWeight) {
        List<Integer> skipRes = new ArrayList<>();

        for (int i = 0; i < newEdges.length; i++) {
            UF skipUF = new UF(n);
            int skipWeight = 0;

            int[] skip = newEdges[i];

            for (int j = 0; j < newEdges.length; j++) {
                if (i == j) {
                    continue;
                }

                int from = newEdges[j][0];
                int to = newEdges[j][1];
                int weight = newEdges[j][2];
                if (!skipUF.connected(from, to)) {
                    skipUF.union(from, to);
                    skipWeight = skipWeight + weight;
                }
            }

            boolean connectedAll = true;
            for (int k = 0; k < n; k++) {
                if (skipUF.find(k) != skipUF.find(0)) {
                    connectedAll = false;
                    break;
                }
            }

            // drop edge, can't connect or connect but skipWeight > totalWeight
            if (!connectedAll || skipWeight > totalWeight) {
                skipRes.add(skip[3]);
            }
        }
        return skipRes;
    }

    private List<Integer> getPseudo(int n, int[][] newEdges, int totalWeight) {
        List<Integer> pickRes = new ArrayList<>();

        for (int i = 0; i < newEdges.length; i++) {
            UF pickUF = new UF(n);
            int pickWeight = 0;


            int[] pick = newEdges[i];
            pickUF.union(pick[0], pick[1]);
            pickWeight = pickWeight + pick[2];

            for (int j = 0; j < newEdges.length; j++) {
                if (i == j) {
                    continue;
                }

                int from = newEdges[j][0];
                int to = newEdges[j][1];
                int weight = newEdges[j][2];
                if (!pickUF.connected(from, to)) {
                    pickUF.union(from, to);
                    pickWeight = pickWeight + weight;
                }
            }

            boolean allConnected = true;
            for (int k = 0; k < n; k++) {
                if (pickUF.find(k) != pickUF.find(0)) {
                    allConnected = false;
                    break;
                }
            }

            // add edge, still connect and same weight
            if (allConnected && pickWeight == totalWeight) {
                //pseudo is not critical
                if (!pickRes.contains(pick[3])) {
                    pickRes.add(pick[3]);
                }
            }
        }

        return pickRes;
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

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
            }
        }
    }
}
